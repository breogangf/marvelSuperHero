package com.fivelabs.marvelsuperhero.ui.presenter;

import com.fivelabs.marvelsuperhero.ui.view.View;

/**
 * Created by breogangf on 6/8/16.
 */
public abstract class AppBase<T extends View> extends Presenter<T> {

  public void onCreate() {}
  public void onResume() {}
  public void onDestroy() {}
}
