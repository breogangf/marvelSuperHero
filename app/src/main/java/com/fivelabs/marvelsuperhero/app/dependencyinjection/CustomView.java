package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.ui.view.View;

/**
 * Created by breogangf on 6/8/16.
 */
public interface CustomView<T extends View> {

  void inject(T view);
}
