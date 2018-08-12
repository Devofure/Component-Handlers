package com.devofure.ch.example.detail;

import android.widget.TextView;

import com.devofure.ch.SourceContent;
import com.devofure.ch.detail.ComponentDetailFragment;
import com.devofure.ch.detail.ViewDataAdapter;
import com.devofure.ch.list.model.Item;

import androidx.annotation.LayoutRes;
import androidx.lifecycle.MutableLiveData;

public class SampleDetailFragment extends ComponentDetailFragment<Item> {

    @Override
    @LayoutRes
    public int getLayout() {
        return com.devofure.ch.example.R.layout.example_component_detail;
    }

    @Override
    public void onDataLoaded(Item item) {
        if (item != null) {
            ((TextView) getLayoutBinding().getRoot().findViewById(com.devofure.ch.example.R.id.component_detail)).setText(item.description.getValue());
        }
    }

    @Override
    public ViewDataAdapter<Item> getViewDataAdapter() {
        return id -> {
            MutableLiveData<Item> liveData = new MutableLiveData<>();
            liveData.setValue(SourceContent.ITEM_MAP.get(id));
            return liveData;
        };
    }
}
