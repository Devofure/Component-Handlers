package com.devofure.ch.list.model;

import androidx.lifecycle.MutableLiveData;

public class Item {

    public MutableLiveData<String> title = new MutableLiveData<>();
    public MutableLiveData<String> description = new MutableLiveData<>();

    public Item(String title, String description) {
        this.title.setValue(title);
        this.description.setValue(description);
    }
}
