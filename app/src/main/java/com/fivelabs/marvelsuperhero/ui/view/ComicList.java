package com.fivelabs.marvelsuperhero.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fivelabs.marvelsuperhero.R;
import com.fivelabs.marvelsuperhero.app.CustomFragment;
import com.fivelabs.marvelsuperhero.app.Main;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.CustomView;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.Application;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.ComponentProvider;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;
import com.fivelabs.marvelsuperhero.ui.presenter.AppBase;
import com.fivelabs.marvelsuperhero.ui.adapter.CustomAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by breogangf on 6/8/16.
 */
public class ComicList extends CustomFragment {

  @Inject protected com.fivelabs.marvelsuperhero.ui.presenter.ComicList comicList;
  @Bind(R.id.loading) protected ProgressBar loading;
  @Bind(R.id.comics_list) protected RecyclerView comicsListView;

  private CustomAdapter customAdapter;
  private StaggeredGridLayoutManager staggeredGridLayoutManager;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public CustomView bindViewComponent() {
    Application application =
        ((Main) getActivity().getApplication()).getApplication();
    return ComponentProvider.getComicsComponent(application);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    buildAdapter();
    presentStaggeredGridLayout();
  }

  @Override
  public void onResume() {
    super.onResume();
    comicList.onViewReady();
  }

  @Override
  public AppBase bindPresenter() {
    return comicList;
  }

  @Override
  public int bindLayout() {
    return R.layout.comic_list;
  }

  private class ScrollListener extends RecyclerView.OnScrollListener {
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
      int lastVisibleItemPosition = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[1] + 1;
      int modelsCount = staggeredGridLayoutManager.getItemCount();
      if (lastVisibleItemPosition == modelsCount) {
        comicList.onLastVisibleItem();
      }
    }
  }

  private void buildAdapter() {
    customAdapter = new CustomAdapter(this.getContext());
  }


  public void showLoadingProgressBar() {
    loading.setVisibility(View.VISIBLE);
  }

  public void hideLoadingProgressBar() {
    loading.setVisibility(View.INVISIBLE);
  }

  private void presentStaggeredGridLayout() {
    staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    comicsListView.setLayoutManager(staggeredGridLayoutManager);
    comicsListView.setAdapter(customAdapter);
  }

  public void showList(List<MarvelComic> marvelComicList) {
    customAdapter.addComics(marvelComicList);
  }

  public void showError(String error) {
    Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
  }

  public void startScrollListener() {
    comicsListView.addOnScrollListener(new ScrollListener());
  }

  public boolean listIsReady() {
    return customAdapter.getItemCount() > 0;
  }

  public static ComicList newInstance() {
    return new ComicList();
  }

}
