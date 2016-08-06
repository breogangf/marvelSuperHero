package com.fivelabs.marvelsuperhero.domain.repository;

import android.content.res.Resources;

import com.fivelabs.marvelsuperhero.data.ComicData;
import com.fivelabs.marvelsuperhero.data.ComicsException;
import com.fivelabs.marvelsuperhero.domain.model.MarvelCharacter;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by breogangf on 6/8/16.
 */
public class DataRepository implements BaseRepository {

  private HashMap<Integer, MarvelComic> comicHashMap;
  private ComicData comicData;
  private MarvelCharacter marvelCharacter;

  public DataRepository(ComicData comicData) {
    this.comicData = comicData;
    init();
  }

  public void initialize(MarvelCharacter marvelCharacter) {
    this.marvelCharacter = marvelCharacter;
  }

  private void init() {
    comicHashMap = new HashMap<>();
  }


  @Override
  public void add(MarvelComic marvelComic) {
    comicHashMap.put(marvelComic.getId(), marvelComic);
  }

  @Override
  public List<MarvelComic> getAll() {
    return new ArrayList<>(comicHashMap.values());
  }


  @Override
  public List<MarvelComic> fetch() {
    return fetch(10);
  }


  @Override
  public MarvelComic findById(int id) {
    if (comicHashMap.containsKey(id)) {
      return comicHashMap.get(id);
    } else {
      throw new Resources.NotFoundException();
    }
  }

  @Override
  public void add(List<MarvelComic> marvelComics) {
    for (MarvelComic marvelComic : marvelComics) {
      add(marvelComic);
    }
  }

  @Override
  public void erase() {
    comicHashMap.clear();
  }

  @Override
  public boolean isEmpty() {
    return comicHashMap.isEmpty();
  }

  @Override
  public List<MarvelComic> fetch(int amount) {
    try {
      List<MarvelComic> marvelComics = comicData.getComicList(amount, comicHashMap.size(), marvelCharacter.getId());
      add(marvelComics);
      return marvelComics;
    } catch (ComicsException e) {
      throw new Resources.NotFoundException();
    }
  }

}
