package com.devofure.ch.list;

import android.app.Activity;

import com.devofure.ch.list.model.Item;
import com.devofure.ch.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devofure.ch.SourceContent;

import java.util.Objects;

/**
 * A fragment representing a single Component detail screen.
 * This fragment is either contained in a {@link ComponentListActivity}
 * in two-pane mode (on tablets) or a {@link ComponentDetailActivity}
 * on handsets.
 */
public class ComponentDetailFragment extends Fragment {

    static final String ARG_ITEM_ID = "item_id";

    private Item mItem;

    public static ComponentDetailFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putString(ComponentDetailFragment.ARG_ITEM_ID, id);
        ComponentDetailFragment fragment = new ComponentDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public ComponentDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Objects.requireNonNull(getArguments()).containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = SourceContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = Objects.requireNonNull(activity).findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.description.getValue());
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.component_detail, container, false);
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.component_detail)).setText(mItem.description.getValue());
        }
        return rootView;
    }
}
