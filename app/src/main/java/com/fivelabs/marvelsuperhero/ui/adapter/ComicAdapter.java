package com.fivelabs.marvelsuperhero.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fivelabs.marvelsuperhero.R;
import com.fivelabs.marvelsuperhero.app.CustomAdapter;
import com.fivelabs.marvelsuperhero.app.Main;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.Application;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.ComponentProvider;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.CustomView;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;
import com.fivelabs.marvelsuperhero.ui.presenter.BaseComic;
import com.fivelabs.marvelsuperhero.ui.presenter.Presenter;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by breogangf on 6/8/16.
 */
public class ComicAdapter extends CustomAdapter {

  @Inject protected BaseComic baseComic;
  @Bind(R.id.title) protected TextView title;
  @Bind(R.id.thumbnail) protected ImageView thumbnail;

  public void render(MarvelComic marvelComic) {
    this.marvelComic = marvelComic;
    baseComic.onAvailable();
  }

  public void drawComic() {
    title.setText(marvelComic.getTitle());
    Picasso.with(context)
            .load(marvelComic.getThumbnailUrl())
            .placeholder(R.drawable.placeholder_landscape)
            .into(thumbnail);
  }

  public ComicAdapter(Context context, ViewGroup viewGroup) {
    super(context, viewGroup);
  }
  private MarvelComic marvelComic;

  @Override
  public CustomView bindViewComponent(Context context) {
    Application application = ((Main) context.getApplicationContext()).getApplication();
    return ComponentProvider.getComicComponent(application);
  }

  @OnClick(R.id.thumbnail)
  public void onThumbnailCLick() {
    baseComic.onItemClicked(marvelComic);
  }

  @Override
  public int bindLayout() {
    return R.layout.comic;
  }

  @Override
  public Presenter bindPresenter() {
    return baseComic;
  }



}
