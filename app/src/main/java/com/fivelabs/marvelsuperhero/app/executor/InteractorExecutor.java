package com.fivelabs.marvelsuperhero.app.executor;

/**
 * Created by breogangf on 6/8/16.
 */
public interface InteractorExecutor extends Executor<Interactor> {

  void execute(Interactor interactor);
}
