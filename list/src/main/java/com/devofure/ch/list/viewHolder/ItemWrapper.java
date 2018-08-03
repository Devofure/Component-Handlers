package com.devofure.ch.list.viewHolder;

public class ItemWrapper<I> {
    private int index;
    private I item;

    public ItemWrapper() {}

    public void setItem(int index, I item) {
        this.index = index;
        this.item = item;
    }

    public I getItem() {
        return item;
    }

    public int getIndex() {
        return index;
    }
}
