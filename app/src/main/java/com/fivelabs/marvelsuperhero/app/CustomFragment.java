package com.fivelabs.marvelsuperhero.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.fivelabs.marvelsuperhero.app.dependencyinjection.CustomView;
import com.fivelabs.marvelsuperhero.ui.presenter.AppBase;
import com.fivelabs.marvelsuperhero.ui.view.View;

import butterknife.ButterKnife;

/**
 * Created by breogangf on 6/8/16.
 */
public abstract class CustomFragment extends Fragment implements View {

    private AppBase presenter;
    private int layout;
    private CustomView customView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        onBeforeInit();
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        layout = bindLayout();
        return inflater.inflate(layout, container, false);
    }

    @Override
    public void onViewCreated(android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);
        ButterKnife.bind(this, getView());
    }

    protected void init() {
        this.customView = bindViewComponent();
        customView.inject(this);
        presenter = bindPresenter();
        presenter.onCreate();
    }

    public abstract CustomView bindViewComponent();

    public abstract AppBase bindPresenter();

    public abstract int bindLayout();

    public void onBeforeInit() {
    }
}
