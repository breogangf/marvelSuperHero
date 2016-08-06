package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.domain.repository.BaseRepository;
import com.fivelabs.marvelsuperhero.ui.presenter.ComicDetail;

import dagger.Module;
import dagger.Provides;

/**
 * Created by breogangf on 6/8/16.
 */
@Module
public class ComicInfoModule {

  @Provides
  public ComicDetail provideComicInfoPresenter(BaseRepository baseRepository) {
    return new ComicDetail(baseRepository);
  }
}
