package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.app.executor.InteractorExecutor;
import com.fivelabs.marvelsuperhero.app.executor.MainThreadExecutor;
import com.fivelabs.marvelsuperhero.domain.interactor.GetMarvelComicsInteractor;
import com.fivelabs.marvelsuperhero.domain.repository.BaseRepository;
import com.fivelabs.marvelsuperhero.ui.presenter.ComicList;
import dagger.Module;
import dagger.Provides;

/**
 * Created by breogangf on 6/8/16.
 */
@Module
public class ComicsModule {

  @Provides
  public GetMarvelComicsInteractor provideGetComicsInteractor(MainThreadExecutor mainThreadExecutor,
                                                              InteractorExecutor interactorExecutor, BaseRepository baseRepository) {
    return new GetMarvelComicsInteractor(mainThreadExecutor, interactorExecutor, baseRepository);
  }

  @Provides
  public ComicList provideComicsPresenter(GetMarvelComicsInteractor getMarvelComicsInteractor,
                                          BaseRepository baseRepository) {
    return new ComicList(getMarvelComicsInteractor, baseRepository);
  }
}
