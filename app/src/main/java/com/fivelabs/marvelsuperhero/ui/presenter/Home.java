package com.fivelabs.marvelsuperhero.ui.presenter;

import com.fivelabs.marvelsuperhero.app.navigator.Navigator;
import com.fivelabs.marvelsuperhero.domain.repository.BaseRepository;
import com.fivelabs.marvelsuperhero.ui.view.MainActivity;

/**
 * Created by breogangf on 6/8/16.
 */
public class Home extends AppBase<MainActivity> {

  private Navigator navigator;
  private boolean mainFetch = true;
  private BaseRepository baseRepository;

  public Home(Navigator navigator, BaseRepository baseRepository) {
    this.navigator = navigator;
    this.baseRepository = baseRepository;
  }

  @Override
  public void onResume() {
    super.onResume();
  }

  @Override
  public void onViewReady() {
    super.onViewReady();
    if (mainFetch) {
      mainFetch = false;
      view.showComicList();
    }
  }

  public void onPortrait() {}

  public void onLandScape() {
    if (!baseRepository.isEmpty()) {
      view.showDetailView(baseRepository.getAll().get(0).getId());
    }
  }
}
