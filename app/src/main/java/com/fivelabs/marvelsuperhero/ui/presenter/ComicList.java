package com.fivelabs.marvelsuperhero.ui.presenter;

import com.fivelabs.marvelsuperhero.domain.interactor.GetMarvelComicsInteractor;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;
import com.fivelabs.marvelsuperhero.domain.repository.BaseRepository;

import java.util.List;

/**
 * Created by breogangf on 6/8/16.
 */
public class ComicList extends AppBase<com.fivelabs.marvelsuperhero.ui.view.ComicList> {

  private ComicsCallback comicsCallback;
  private boolean fetching = false;
  private GetMarvelComicsInteractor getMarvelComicsInteractor;
  private BaseRepository baseRepository;

  public ComicList(GetMarvelComicsInteractor getMarvelComicsInteractor, BaseRepository baseRepository) {
    this.getMarvelComicsInteractor = getMarvelComicsInteractor;
    this.baseRepository = baseRepository;
    init();
  }

  private void init() {
    comicsCallback = new ComicsCallback();
  }

  @Override
  public void onViewReady() {
    super.onViewReady();
    if (!view.listIsReady()) {
      populateComics();
    }
    view.startScrollListener();
  }

  private void populateComics() {
    if (baseRepository.isEmpty()) {
      getComics();
    } else {
      view.showList(baseRepository.getAll());
    }
  }

  private void getComics() {
    view.showLoadingProgressBar();
    getMarvelComicsInteractor.execute(10, comicsCallback);
  }

  private void getNextComics() {
    if (!fetching) {
      fetching = true;
      view.showLoadingProgressBar();
      getMarvelComicsInteractor.execute(8, comicsCallback);
    }
  }

  @Override
  public void onResume() {
    super.onResume();
  }

  public void onLastVisibleItem() {
    getNextComics();
  }

  private class ComicsCallback implements GetMarvelComicsInteractor.ComicsInteractorCallback {

    @Override
    public void onComicsFetch(List<MarvelComic> marvelComicList) {
      view.hideLoadingProgressBar();
      view.showList(marvelComicList);
      view.startScrollListener();
      fetching = false;
    }

    @Override
    public void onFetchError() {
      view.hideLoadingProgressBar();
      view.showError("Fetch Error");
      fetching = false;
    }
  }
}
