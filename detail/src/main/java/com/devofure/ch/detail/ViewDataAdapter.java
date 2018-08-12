package com.devofure.ch.detail;

import androidx.lifecycle.LiveData;

public interface ViewDataAdapter<I> {
    LiveData<I> get(String key);
}
