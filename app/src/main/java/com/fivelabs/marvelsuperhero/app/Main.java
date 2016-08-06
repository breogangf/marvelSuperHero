package com.fivelabs.marvelsuperhero.app;

import android.app.Activity;
import android.os.Bundle;

import com.fivelabs.marvelsuperhero.app.dependencyinjection.Application;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.DaggerApplication;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.ApplicationModule;
import com.fivelabs.marvelsuperhero.app.navigator.Navigator;
import javax.inject.Inject;

/**
 * Created by breogangf on 6/8/16.
 */
public class Main extends android.app.Application implements android.app.Application.ActivityLifecycleCallbacks {

  @Inject protected Navigator navigator;
  private Application application;

  @Override public void onCreate() {
    super.onCreate();
    buildApplicationComponent();
    inject();
    this.registerActivityLifecycleCallbacks(this);
  }

  private void buildApplicationComponent() {
    application =
        DaggerApplication.builder().applicationModule(new ApplicationModule(this)).build();
  }

  private void inject() {
    application.inject(this);
  }

  public Application getApplication() {
    return application;
  }

  @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    navigator.loadActivity(activity);
  }

  @Override public void onActivityStarted(Activity activity) {}

  @Override public void onActivityResumed(Activity activity) {}

  @Override public void onActivityPaused(Activity activity) {}

  @Override public void onActivityStopped(Activity activity) {}

  @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}

  @Override public void onActivityDestroyed(Activity activity) {}
}
