package com.devofure.ch.list.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.devofure.ch.list.R;
import com.devofure.ch.list.model.Item;
import com.devofure.ch.list.viewHolder.ItemClickHandler;
import com.devofure.ch.list.viewHolder.ItemViewHolder;
import com.devofure.ch.list.viewHolder.Settings;
import com.devofure.ch.list.databinding.ItemHorizontalBinding;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class RecyclerListAdapter<I extends Item> extends ListAdapter<I, ItemViewHolder<I>> {

    @LayoutRes
    private int itemLayout;
    private ItemClickHandler itemHandler;
    private Settings settings;
    private OnBindListener onBindListener;

    private RecyclerListAdapter(@NonNull DiffUtil.ItemCallback<I> diffCallback) {
        super(diffCallback);
    }

    public static <I extends Item> RecyclerListAdapter<I> withVerticalLayout(@NonNull DiffUtil.ItemCallback<I> diffCallback){
        return new RecyclerListAdapter<>(diffCallback).setItemLayout(R.layout.item_vertical);
    }
    public static <I extends Item> RecyclerListAdapter<I> withHorizontal(@NonNull DiffUtil.ItemCallback<I> diffCallback){
        return new RecyclerListAdapter<>(diffCallback).setItemLayout(R.layout.item_horizontal);
    }

    @NonNull
    @Override
    public ItemViewHolder<I> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding itemBinding = createItemBinding(parent, layoutInflater);
        return new ItemViewHolder<>(itemBinding, settings, itemHandler);
    }

    private ViewDataBinding createItemBinding(@NonNull ViewGroup parent, LayoutInflater layoutInflater) {
        return DataBindingUtil.inflate(layoutInflater, itemLayout, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder<I> holder, int position) {
        if(onBindListener != null){
            onBindListener.onBind(holder, position);
        }else{
            holder.bind(position, getItem(position));
        }
    }

    public <IH extends ItemClickHandler> RecyclerListAdapter<I> setItemClickHandler(IH itemHandler) {
        this.itemHandler = itemHandler;
        return this;
    }

    public RecyclerListAdapter<I> onBind(OnBindListener onBindListener) {
        this.onBindListener = onBindListener;
        return this;
    }
    public RecyclerListAdapter<I> setItemSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    public ItemClickHandler getItemHandler() {
        return itemHandler;
    }

    public Settings getSettings() {
        return settings;
    }

    public RecyclerListAdapter<I> setItemLayout(int itemLayout) {
        this.itemLayout = itemLayout;
        return this;
    }

    public interface OnBindListener {
        void onBind(ItemViewHolder holder, int position);
    }
}
