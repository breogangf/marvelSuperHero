package com.fivelabs.marvelsuperhero.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.fivelabs.marvelsuperhero.app.dependencyinjection.CustomView;
import com.fivelabs.marvelsuperhero.ui.presenter.Presenter;
import com.fivelabs.marvelsuperhero.ui.view.View;

import butterknife.ButterKnife;

/**
 * Created by breogangf on 6/8/16.
 */
public abstract class CustomAdapter implements View {

  protected Context context;
  protected android.view.View view;
  protected ViewGroup viewGroup;
  private CustomView customView;
  private int layout;
  private Presenter presenter;

  public CustomAdapter(Context context, ViewGroup viewGroup) {
    this.context = context;
    this.viewGroup = viewGroup;
    customView = bindViewComponent(context.getApplicationContext());
    customView.inject(this);
    presenter = bindPresenter();
    initView();
    ButterKnife.bind(this, view);
    presenter.attachView(this);
    presenter.onViewReady();
    onAfterCreate();
  }

  private void initView() {
    layout = bindLayout();
    this.view = LayoutInflater.from(context).inflate(layout, viewGroup, false);
  }

  public void onAfterCreate() { }

  public abstract CustomView bindViewComponent(Context context);

  public abstract Presenter bindPresenter();

  public abstract int bindLayout();

  public android.view.View getView() {
    return view;
  }
}
