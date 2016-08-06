package com.fivelabs.marvelsuperhero.domain.interactor;

import com.fivelabs.marvelsuperhero.app.executor.Interactor;
import com.fivelabs.marvelsuperhero.app.executor.InteractorExecutor;
import com.fivelabs.marvelsuperhero.app.executor.MainThreadExecutor;

/**
 * Created by breogangf on 6/8/16.
 */
public abstract class AbstractInteractor implements Interactor {

  protected MainThreadExecutor mainThreadExecutor;
  protected InteractorExecutor interactorExecutor;

  protected AbstractInteractor(MainThreadExecutor mainThreadExecutor,
      InteractorExecutor interactorExecutor) {
    this.mainThreadExecutor = mainThreadExecutor;
    this.interactorExecutor = interactorExecutor;
  }

  protected void execute() {
    interactorExecutor.execute(this);
  }

  protected void executeOnMainThread(Runnable runnable) {
    mainThreadExecutor.execute(runnable);
  }
}
