package com.devofure.ch.list.viewHolder;

import com.devofure.ch.list.BR;
import com.devofure.ch.list.model.Item;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder<I extends Item> extends RecyclerView.ViewHolder {

    private final ViewDataBinding itemFoodBinding;
    private final Settings staticSettings;
    private final ItemClickHandler staticItemHandler;
    private ItemWrapper<I> itemWrapper;

    public ItemViewHolder(ViewDataBinding itemFoodBinding, Settings staticSettings, ItemClickHandler staticItemHandler) {
        super(itemFoodBinding.getRoot());
        this.itemFoodBinding = itemFoodBinding;
        this.staticSettings = staticSettings;
        this.staticItemHandler = staticItemHandler;
    }

    public ItemViewHolder(ViewDataBinding itemFoodBinding) {
        this(itemFoodBinding, null, null);
    }

    public ItemViewHolder(ViewDataBinding itemFoodBinding, Settings staticSettings) {
        this(itemFoodBinding, staticSettings, null);
    }

    public void bind(int index, I item, ItemClickHandler itemHandler, Settings settings) {
        if(itemWrapper == null){
            itemWrapper = new ItemWrapper<>();
        }
        itemWrapper.setItem(index, item);
        this.itemFoodBinding.setVariable(BR.itemWrapper, itemWrapper);
        this.itemFoodBinding.setVariable(BR.settings, settings);
        this.itemFoodBinding.setVariable(BR.clickHandler, itemHandler);
        this.itemFoodBinding.executePendingBindings();
    }

    public void bind(int index, I item, ItemClickHandler itemHandler) {
        bind(index, item, itemHandler, staticSettings);
    }

    public void bind(int index, I item) {
        bind(index, item, staticItemHandler, staticSettings);
    }
}