package com.devofure.ch.detail;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import java.util.Objects;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class ComponentDetailFragment<I> extends Fragment {

    public static final String ARG_ITEM_ID = "item_id_jhijhsdfds";
    public static final String ARG_ITEM_PARCELABLE = "item_parcelable_kihflsjuh";

    private I mItem;
    private ViewDataBinding mLayoutBinding;

    public ComponentDetailFragment() {
    }

    public static <F extends ComponentDetailFragment> ComponentDetailFragment newInstance(String id, Class<F> clazz) {
        Bundle args = new Bundle();
        args.putString(ComponentDetailFragment.ARG_ITEM_ID, id);
        return createFragment(clazz, args);
    }

    public static <I extends Parcelable, F extends ComponentDetailFragment> F newInstance(I model, Class<F> clazz) {
        Bundle args = new Bundle();
        args.putParcelable(ComponentDetailFragment.ARG_ITEM_PARCELABLE, model);
        return createFragment(clazz, args);
    }

    private static <F extends Fragment> F createFragment(Class<F> clazz, Bundle args) {
        F fragment;
        try {
            fragment = clazz.newInstance();
            fragment.setArguments(args);
        } catch (IllegalAccessException | java.lang.InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (Objects.requireNonNull(getArguments()).containsKey(ARG_ITEM_ID)) {
            getViewDataAdapter().get(getArguments().getString(ARG_ITEM_ID)).observe(this, this::onDataLoaded);
        } else if (Objects.requireNonNull(getArguments()).containsKey(ARG_ITEM_PARCELABLE)) {
            onDataLoaded(Parcels.unwrap(getArguments().getParcelable(ARG_ITEM_PARCELABLE)));
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mLayoutBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
        return mLayoutBinding.getRoot();
    }

    public ViewDataBinding getLayoutBinding() {
        return mLayoutBinding;
    }

    @LayoutRes
    public abstract int getLayout();

    public void onDataLoaded(I i) {
    }

    public abstract ViewDataAdapter<I> getViewDataAdapter();
}
