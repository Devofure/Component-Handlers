package com.devofure.ch.example.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devofure.ch.SourceContent;
import com.devofure.ch.core.BaseActivity;
import com.devofure.ch.detail.ComponentDetailFragment;
import com.devofure.ch.example.R;
import com.devofure.ch.example.list.model.MockObject;
import com.devofure.ch.list.adapter.RecyclerListAdapter;
import com.devofure.ch.list.model.Item;
import com.devofure.ch.list.viewHolder.ItemClickSimpleHandler;
import com.devofure.ch.list.viewHolder.ItemWrapper;
import com.devofure.ch.list.viewHolder.Settings;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ComponentListActivity extends BaseActivity {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.devofure.ch.example.R.layout.activity_component_list);

        RecyclerView recyclerView = findViewById(com.devofure.ch.example.R.id.component_list);
        mTwoPane = findViewById(com.devofure.ch.example.R.id.component_detail_container) != null;

        setupToolbar(getTitle().toString());
        setupRecyclerView(recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        RecyclerListAdapter<Item> recyclerAdapter = getRecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerAdapter.submitList(SourceContent.ITEMS);
    }

    private RecyclerListAdapter<Item> getRecyclerAdapter() {
        return RecyclerListAdapter.withHorizontal(getDiffCallback())
                .setItemSettings(getItemSettings())
                .setItemClickHandler(getItemClickListenerHandler());
    }

    private ItemClickSimpleHandler<ItemWrapper<MockObject>> getItemClickListenerHandler() {
        return new ItemClickSimpleHandler<ItemWrapper<MockObject>>() {
            @Override
            public void onItemClick(View view, ItemWrapper<MockObject> item) {
                if (mTwoPane) {
                    ComponentDetailFragment fragment = ComponentDetailFragment.newInstance(String.valueOf(item.getIndex()), ComponentDetailFragment.class);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.component_detail_container, fragment)
                            .commit();
                } else {
                    Intent intent = ComponentDetailActivity.newInstance(ComponentListActivity.this, String.valueOf(item.getIndex()));
                    ComponentListActivity.this.startActivity(intent);
                }
            }
        };
    }

    private Settings getItemSettings() {
        return new Settings().showHeart(false).showStars(false);//.setItemMenu(R.menu.item_menu);
    }

    private DiffUtil.ItemCallback<Item> getDiffCallback() {
        return new DiffUtil.ItemCallback<Item>() {
            @Override
            public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
                return oldItem.title.equals(newItem.title);
            }

            @Override
            public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
                return oldItem.description.equals(newItem.description);
            }
        };
    }
}
