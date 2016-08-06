package com.fivelabs.marvelsuperhero.domain.interactor;

import android.content.res.Resources;

import com.fivelabs.marvelsuperhero.app.executor.InteractorExecutor;
import com.fivelabs.marvelsuperhero.app.executor.MainThreadExecutor;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;
import com.fivelabs.marvelsuperhero.domain.repository.BaseRepository;

import java.util.List;

/**
 * Created by breogangf on 6/8/16.
 */
public class GetMarvelComicsInteractor extends AbstractInteractor {

  private BaseRepository baseRepository;
  private int amount;
  private ComicsInteractorCallback comicsInteractorCallback;

  public GetMarvelComicsInteractor(MainThreadExecutor mainThreadExecutor,
                                   InteractorExecutor interactorExecutor, BaseRepository baseRepository) {
    super(mainThreadExecutor, interactorExecutor);
    this.baseRepository = baseRepository;
  }

  public void execute(ComicsInteractorCallback comicsInteractorCallback) {
    this.comicsInteractorCallback = comicsInteractorCallback;
    execute();
  }

  public void execute(int amount, ComicsInteractorCallback comicsInteractorCallback) {
    this.comicsInteractorCallback = comicsInteractorCallback;
    this.amount = amount;
    execute();
  }

  @Override
  public void run() {
    try {
      List<MarvelComic> marvelComics;
      if (amount != 0) {
        marvelComics = baseRepository.fetch(amount);
      } else {
        marvelComics = baseRepository.fetch();
      }
      doOnComicsSuccess(marvelComics);
    } catch (Resources.NotFoundException e) {
      doOnComicsError();
    }
  }

  private void doOnComicsSuccess(final List<MarvelComic> marvelComics) {
    executeOnMainThread(new Runnable() {
      @Override
      public void run() {
        comicsInteractorCallback.onComicsFetch(marvelComics);
      }
    });
  }

  public void doOnComicsError() {
    executeOnMainThread(new Runnable() {
      @Override
      public void run() {
        comicsInteractorCallback.onFetchError();
      }
    });
  }

  public interface ComicsInteractorCallback {

    void onComicsFetch(List<MarvelComic> marvelComicList);

    void onFetchError();
  }
}
