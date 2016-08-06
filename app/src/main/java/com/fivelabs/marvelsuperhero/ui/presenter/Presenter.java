package com.fivelabs.marvelsuperhero.ui.presenter;

import com.fivelabs.marvelsuperhero.ui.view.View;

/**
 * Created by breogangf on 6/8/16.
 */
public abstract class Presenter<T extends View> {

  protected T view;

  public void attachView(T view) {
    this.view = view;
  }


  public void onViewReady() { }
}
