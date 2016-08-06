package com.fivelabs.marvelsuperhero.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by breogangf on 6/8/16.
 */
public class CustomAdapter extends RecyclerView.Adapter {

  private Context context;
  private List<MarvelComic> marvelComics;

  public CustomAdapter(Context context) {
    this.context = context;
    this.marvelComics = new ArrayList<>();
  }

  private class ComicViewHolder extends RecyclerView.ViewHolder {

    protected ComicAdapter comicView;

    public ComicViewHolder(ComicAdapter comicView) {
      super(comicView.getView());
      this.comicView = comicView;
    }
  }

  @Override
  public int getItemCount() {
    return marvelComics.size();
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return makeComicView(parent);
  }

  private RecyclerView.ViewHolder makeComicView(ViewGroup viewGroup) {
    ComicAdapter comicView = new ComicAdapter(context, viewGroup);
    return new ComicViewHolder(comicView);
  }

  public void addComic(MarvelComic marvelComic) {
    marvelComics.add(marvelComic);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    MarvelComic marvelComic = marvelComics.get(position);
    ((ComicViewHolder) holder).comicView.render(marvelComic);
  }

  public void addComics(List<MarvelComic> marvelComics) {
    for (MarvelComic marvelComic : marvelComics) {
      addComic(marvelComic);
    }
    notifyDataSetChanged();
  }


}
