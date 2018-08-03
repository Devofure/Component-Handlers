package com.devofure.ch.list.viewHolder;

import android.view.MenuItem;
import android.view.View;

public abstract class ItemClickSimpleHandler<I> implements ItemClickHandler<I> {

    @Override
    public void onItemMenuClick(View view, I item, MenuItem itemMenu) {

    }

    @Override
    public void onItemHeartClick(View view, I item) {
        //Do nothing
    }
}

