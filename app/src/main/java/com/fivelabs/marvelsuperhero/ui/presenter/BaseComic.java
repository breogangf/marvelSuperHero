package com.fivelabs.marvelsuperhero.ui.presenter;

import com.fivelabs.marvelsuperhero.app.navigator.Navigator;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;
import com.fivelabs.marvelsuperhero.ui.adapter.ComicAdapter;

/**
 * Created by breogangf on 6/8/16.
 */
public class BaseComic extends Presenter<ComicAdapter> {

  private Navigator navigator;

  public BaseComic(Navigator navigator) {
    this.navigator = navigator;
  }

  public void onItemClicked(MarvelComic marvelComic) {
    navigator.loadDetailView(marvelComic.getId());
  }

  public void onAvailable() {
    view.drawComic();
  }

}
