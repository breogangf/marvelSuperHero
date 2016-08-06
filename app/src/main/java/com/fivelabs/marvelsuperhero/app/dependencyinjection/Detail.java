package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import dagger.Component;

/**
 * Created by breogangf on 6/8/16.
 */
@Component(dependencies = Application.class, modules = DetailViewModule.class) @CView
public interface Detail extends CustomView<com.fivelabs.marvelsuperhero.ui.view.Detail> {

  @Override void inject(com.fivelabs.marvelsuperhero.ui.view.Detail detail);
}
