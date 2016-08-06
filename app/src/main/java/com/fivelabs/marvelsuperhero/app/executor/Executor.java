package com.fivelabs.marvelsuperhero.app.executor;

/**
 * Created by breogangf on 6/8/16.
 */
public interface Executor<T extends Runnable> {

  void execute(T runnable);
}
