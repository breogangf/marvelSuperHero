package com.fivelabs.marvelsuperhero.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fivelabs.marvelsuperhero.R;
import com.fivelabs.marvelsuperhero.app.CustomFragment;
import com.fivelabs.marvelsuperhero.app.Main;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.CustomView;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.Application;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.ComponentProvider;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;
import com.fivelabs.marvelsuperhero.ui.presenter.ComicDetail;
import com.fivelabs.marvelsuperhero.ui.presenter.AppBase;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by breogangf on 6/8/16.
 */
public class ComicFragment extends CustomFragment {

  @Inject protected ComicDetail comicDetail;

  @Bind(R.id.year) protected TextView year;
  @Bind(R.id.title) protected TextView title;
  @Bind(R.id.header_image) protected ImageView imageView;
  @Bind(R.id.description) protected TextView description;
  @Bind(R.id.no_character) protected TextView noData;

  @Override
  public CustomView bindViewComponent() {
    Application application =
        ((Main) getActivity().getApplication()).getApplication();
    return ComponentProvider.getComicInfoComponent(application);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    if (getArguments() != null) {
      int comicId = getArguments().getInt("comicId");
      comicDetail.onComicIdAvailable(comicId);
    }
  }

  @Override
  public AppBase bindPresenter() {
    return comicDetail;
  }

  @Override
  public int bindLayout() {
    return R.layout.comic_detail;
  }

  public void showError() {
    noData.setVisibility(View.VISIBLE);
  }

  public void clearError() {
    noData.setVisibility(View.INVISIBLE);
  }

  public static ComicFragment newInstance(int comicId) {
    Bundle args = new Bundle();
    args.putInt("comicId", comicId);
    ComicFragment comicFragment = new ComicFragment();
    comicFragment.setArguments(args);
    return comicFragment;
  }

  public void prensentInfo(MarvelComic marvelComic) {
    title.setText(marvelComic.getTitle());
    year.setText(marvelComic.getYear());
    description.setText(marvelComic.getDescription());
  }

  public void presentImage(String image) {
    Picasso.with(getContext())
        .load(image)
        .placeholder(R.drawable.placeholder)
        .into(imageView);
  }


}
