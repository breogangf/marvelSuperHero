package com.fivelabs.marvelsuperhero.app.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by breogangf on 6/8/16.
 */
public class DefaultInteractorExecutor implements InteractorExecutor {


  private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>();

  private ThreadPoolExecutor threadPoolExecutor;

  public DefaultInteractorExecutor() {
    threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60, TimeUnit.SECONDS, WORK_QUEUE);
  }

  @Override public void execute(Interactor interactor) {
    if (interactor != null) {
      threadPoolExecutor.submit(interactor);
    }
  }
}
