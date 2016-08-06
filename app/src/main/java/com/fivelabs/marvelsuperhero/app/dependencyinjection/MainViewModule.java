package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.app.navigator.Navigator;
import com.fivelabs.marvelsuperhero.domain.repository.BaseRepository;
import com.fivelabs.marvelsuperhero.ui.presenter.Home;
import dagger.Module;
import dagger.Provides;

/**
 * Created by breogangf on 6/8/16.
 */
@Module
public class MainViewModule {

  @Provides
  @CView
  Home provideMainPresenter(Navigator navigator, BaseRepository baseRepository) {
    return new com.fivelabs.marvelsuperhero.ui.presenter.Home(navigator, baseRepository);
  }
}
