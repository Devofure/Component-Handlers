package com.devofure.ch.core;

import com.devofure.ch.R;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * The toolbar id should be "toolbar"
     */
    public void setupToolbar() {
        setupToolbar(null);
    }

    /**
     * The toolbar id should be "toolbar"
     * @param title
     */
    public void setupToolbar(String title) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setupToolbar(toolbar, title);
    }

    public void setupToolbar(Toolbar toolbar, String title) {
        setSupportActionBar(toolbar);
        toolbar.setTitle(title);
    }

    public void setupToolbar(Toolbar toolbar, @StringRes int title) {
        setSupportActionBar(toolbar);
        toolbar.setTitle(title);
    }

    public void setupToolbar(@IdRes int toolbarId, String title) {
        Toolbar toolbar = findViewById(toolbarId);
        setupToolbar(toolbar, title);
    }

    public void setupToolbar(@IdRes int toolbarId, @StringRes int title) {
        Toolbar toolbar = findViewById(toolbarId);
        setupToolbar(toolbar, title);
    }
}
