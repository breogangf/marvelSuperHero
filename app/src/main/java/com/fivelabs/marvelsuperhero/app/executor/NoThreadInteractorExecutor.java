package com.fivelabs.marvelsuperhero.app.executor;

/**
 * Created by breogangf on 6/8/16.
 */
public class NoThreadInteractorExecutor implements InteractorExecutor {

  @Override public void execute(Interactor interactor) {
    interactor.run();
  }
}
