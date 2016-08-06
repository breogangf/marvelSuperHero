package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.data.ComicData;
import com.fivelabs.marvelsuperhero.domain.model.MarvelCharacter;
import com.fivelabs.marvelsuperhero.domain.repository.BaseRepository;
import com.fivelabs.marvelsuperhero.domain.repository.DataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by breogangf on 6/8/16.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public BaseRepository provideComicRepository(ComicData comicData) {
        DataRepository comicRepository =
                new DataRepository(comicData);
        MarvelCharacter ironMan = new MarvelCharacter();
        ironMan.setId(1009368);
        comicRepository.initialize(ironMan);
        return comicRepository;
    }
}
