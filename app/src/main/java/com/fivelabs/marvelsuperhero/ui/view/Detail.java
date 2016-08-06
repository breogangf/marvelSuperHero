package com.fivelabs.marvelsuperhero.ui.view;

import com.fivelabs.marvelsuperhero.R;
import com.fivelabs.marvelsuperhero.app.CustomActivity;
import com.fivelabs.marvelsuperhero.app.Main;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.Application;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.ComponentProvider;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.CustomView;
import com.fivelabs.marvelsuperhero.ui.presenter.Info;
import com.fivelabs.marvelsuperhero.ui.presenter.AppBase;

import javax.inject.Inject;

/**
 * Created by breogangf on 6/8/16.
 */
public class Detail extends CustomActivity {

  @Inject protected Info info;

  @Override
  public void onViewReady() {
    super.onViewReady();
    int comidId = getIntent().getExtras().getInt("comicId");
    info.onComicIdFetched(comidId);
  }

  @Override
  public CustomView bindViewComponent() {
    Application application =
        ((Main) getApplication()).getApplication();
    return ComponentProvider.getDetailViewComponent(application);
  }

  @Override
  public AppBase bindPresenter() {
    return info;
  }

  @Override
  public int bindLayout() {
    return R.layout.info;
  }

  public void showComicInfo(int comicId) {
    ComicFragment comicFragment = ComicFragment.newInstance(comicId);
    getSupportFragmentManager().beginTransaction()
        .add(R.id.comic_info_frame, comicFragment)
        .commit();
  }
}
