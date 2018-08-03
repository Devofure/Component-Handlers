package com.devofure.ch.list.viewHolder;

import androidx.annotation.ColorRes;
import androidx.annotation.MenuRes;

public class Settings {

    private boolean showHeart;
    private boolean showStars;
    @ColorRes
    private int heartColor = 0;
    @MenuRes
    private int itemMenu = 0;

    public Settings setItemMenu(@MenuRes Integer itemMenu) {
        this.itemMenu = itemMenu;
        return this;
    }
    public Settings showHeart(boolean showHeart) {
        this.showHeart = showHeart;
        return this;
    }

    public Settings showStars(boolean showStars) {
        this.showStars = showStars;
        return this;
    }

    public Settings setHeartColor(@ColorRes Integer heartColor) {
        this.heartColor = heartColor;
        return this;
    }

    public boolean isShowHeart() {
        return showHeart;
    }

    public boolean isShowStars() {
        return showStars;
    }

    @ColorRes
    public int getHeartColor() {
        return heartColor;
    }

    @MenuRes
    public int getItemMenu() {
        return itemMenu;
    }
}
