package com.devofure.ch.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.devofure.ch.R;
import com.devofure.ch.core.BaseActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.view.MenuItem;

public class ComponentDetailActivity extends BaseActivity {

    public static Intent newInstance(Context activityContext, String id) {
        Intent intent = new Intent(activityContext, ComponentDetailActivity.class);
        intent.putExtra(ComponentDetailFragment.ARG_ITEM_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_detail);
        setupToolbar();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(
                view,
                "Replace with your own detail action",
                Snackbar.LENGTH_LONG).setAction("Action", null).show());

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (savedInstanceState == null) {
            ComponentDetailFragment fragment = ComponentDetailFragment.newInstance(getIntent().getStringExtra(ComponentDetailFragment.ARG_ITEM_ID));
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.component_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, ComponentListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
