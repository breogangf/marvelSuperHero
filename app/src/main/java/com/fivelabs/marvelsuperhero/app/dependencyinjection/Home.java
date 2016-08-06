package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.ui.view.MainActivity;

import dagger.Component;

/**
 * Created by breogangf on 6/8/16.
 */
@Component(dependencies = Application.class, modules = MainViewModule.class) @CView
public interface Home extends CustomView<MainActivity> {

  @Override void inject(MainActivity mainActivityView);
}
