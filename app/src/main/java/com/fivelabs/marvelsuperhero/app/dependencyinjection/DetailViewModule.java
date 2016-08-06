package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.ui.presenter.Info;

import dagger.Module;
import dagger.Provides;

/**
 * Created by breogangf on 6/8/16.
 */
@Module public class DetailViewModule {

  @Provides public Info provideDetailPresenter() {
    return new Info();
  }
}
