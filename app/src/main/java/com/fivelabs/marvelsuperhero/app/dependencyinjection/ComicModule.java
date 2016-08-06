package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.app.navigator.Navigator;
import com.fivelabs.marvelsuperhero.ui.presenter.BaseComic;

import dagger.Module;
import dagger.Provides;

/**
 * Created by breogangf on 6/8/16.
 */
@Module
public class ComicModule {

  @Provides
  public BaseComic provideComicPresenter(Navigator navigator) {
    return new BaseComic(navigator);
  }
}
