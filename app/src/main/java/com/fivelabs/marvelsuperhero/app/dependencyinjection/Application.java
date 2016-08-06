package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.app.Main;
import com.fivelabs.marvelsuperhero.app.executor.InteractorExecutor;
import com.fivelabs.marvelsuperhero.app.executor.MainThreadExecutor;
import com.fivelabs.marvelsuperhero.app.navigator.Navigator;
import com.fivelabs.marvelsuperhero.domain.repository.BaseRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by breogangf on 6/8/16.
 */
@Singleton
@Component(modules = { ApplicationModule.class, RepositoryModule.class, DataSource.class })
public interface Application {

  void inject(Main main);

  MainThreadExecutor mainThreadExecutor();

  InteractorExecutor interactorExecutor();

  Navigator navigator();

  BaseRepository comicRepository();
}
