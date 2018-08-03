package com.devofure.ch.list.viewHolder;

import android.view.MenuItem;
import android.view.View;

public interface ItemClickHandler<I> {

    void onItemClick(View view, I item);
    void onItemMenuClick(View view, I item, MenuItem itemMenu);
    void onItemHeartClick(View view, I item);
}

