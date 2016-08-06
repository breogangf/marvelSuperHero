package com.fivelabs.marvelsuperhero.data;

import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;

import java.util.List;

/**
 * Created by breogangf on 6/8/16.
 */
public interface ComicData {

  List<MarvelComic> getComicList(int limit, int characterId) throws ComicsException;

  List<MarvelComic> getComicList(int limit, int offset, int characterId) throws ComicsException;
}
