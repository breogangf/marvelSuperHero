package com.fivelabs.marvelsuperhero.app.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by breogangf on 6/8/16.
 */
public class MainThreadExecutorImp implements MainThreadExecutor<Runnable> {

  private Handler handler;

  public MainThreadExecutorImp() {
    this.handler = new Handler(Looper.getMainLooper());
  }

  @Override public void execute(Runnable runnable) {
    handler.post(runnable);
  }
}
