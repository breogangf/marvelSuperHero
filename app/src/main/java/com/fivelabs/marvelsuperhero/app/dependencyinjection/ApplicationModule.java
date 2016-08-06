package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import android.content.Context;

import com.fivelabs.marvelsuperhero.app.Main;
import com.fivelabs.marvelsuperhero.app.executor.DefaultInteractorExecutor;
import com.fivelabs.marvelsuperhero.app.executor.InteractorExecutor;
import com.fivelabs.marvelsuperhero.app.executor.MainThreadExecutor;
import com.fivelabs.marvelsuperhero.app.executor.MainThreadExecutorImp;
import com.fivelabs.marvelsuperhero.app.navigator.DefaultNavigator;
import com.fivelabs.marvelsuperhero.app.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by breogangf on 6/8/16.
 */
@Module public class ApplicationModule {

  private final Main application;

  public ApplicationModule(Main main) {
    this.application = main;
  }

  @Provides @Singleton public MainThreadExecutor provideMainThreadExecutor() {
    return new MainThreadExecutorImp();
  }

  @Provides @Singleton public InteractorExecutor provideInteractorExecutor() {
    return new DefaultInteractorExecutor();
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton Navigator provideNavigator() {
    return new DefaultNavigator();
  }
}
