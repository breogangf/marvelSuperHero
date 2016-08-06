package com.fivelabs.marvelsuperhero.ui.presenter;

import com.fivelabs.marvelsuperhero.ui.view.Detail;

/**
 * Created by breogangf on 6/8/16.
 */
public class Info extends AppBase<Detail> {
  private boolean mainFetch = true;

  public void onComicIdFetched(int comicId) {
    if (mainFetch) {
      mainFetch = false;
      view.showComicInfo(comicId);
    }
  }
}
