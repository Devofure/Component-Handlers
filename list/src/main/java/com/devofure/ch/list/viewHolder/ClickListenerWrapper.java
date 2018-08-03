package com.devofure.ch.list.viewHolder;

import android.view.MenuInflater;
import android.view.View;

import androidx.appcompat.widget.PopupMenu;

public class ClickListenerWrapper {

    public static void onItemMenuClick(View view, Object item, Settings settings, ItemClickHandler clickHandler){
        if(settings.getItemMenu() == 0){
            return;
        }
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        popupMenu.setOnMenuItemClickListener(menuItem -> {
            clickHandler.onItemMenuClick(view, item, menuItem);
            return true;
        });
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(settings.getItemMenu(), popupMenu.getMenu());
        popupMenu.show();
    }
}
