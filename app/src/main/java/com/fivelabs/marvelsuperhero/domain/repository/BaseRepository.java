package com.fivelabs.marvelsuperhero.domain.repository;

import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;

import java.util.List;

/**
 * Created by breogangf on 6/8/16.
 */
public interface BaseRepository {

  void add(MarvelComic marvelComic);
  void add(List<MarvelComic> marvelComics);
  List<MarvelComic> fetch();
  List<MarvelComic> fetch(int amount);
  void erase();
  List<MarvelComic> getAll();
  MarvelComic findById(int id);

  boolean isEmpty();

}
