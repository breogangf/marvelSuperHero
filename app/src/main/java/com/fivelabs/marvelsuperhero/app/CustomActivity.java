package com.fivelabs.marvelsuperhero.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fivelabs.marvelsuperhero.app.dependencyinjection.CustomView;
import com.fivelabs.marvelsuperhero.ui.presenter.AppBase;
import com.fivelabs.marvelsuperhero.ui.view.View;

import butterknife.ButterKnife;

/**
 * Created by breogangf on 6/8/16.
 */
public abstract class CustomActivity extends AppCompatActivity implements View {

  protected android.view.View view;
  private AppBase presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    onBeforeInit();
    super.onCreate(savedInstanceState);
    init();
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.onResume();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }

  protected void init() {
    CustomView customView = bindViewComponent();
    customView.inject(this);
    presenter = bindPresenter();
    int layout = bindLayout();
    presenter.attachView(this);
    presenter.onCreate();
    view = getLayoutInflater().inflate(layout, null);
    setContentView(view);
    ButterKnife.bind(this);
    onViewReady();
  }

  public abstract CustomView bindViewComponent();

  public abstract AppBase bindPresenter();

  public abstract int bindLayout();

  public void onBeforeInit() {  }

  public void onViewReady() {  }
}

