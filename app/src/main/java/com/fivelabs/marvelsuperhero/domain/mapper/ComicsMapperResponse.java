package com.fivelabs.marvelsuperhero.domain.mapper;

import com.fivelabs.marvelsuperhero.data.model.ComicsResponse;
import com.fivelabs.marvelsuperhero.data.model.RequestResponse;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by breogangf on 6/8/16.
 */
public class ComicsMapperResponse implements Mapper<ComicsResponse, List<MarvelComic>> {

  private ComicMapperResponse comicMapperResponse;

  public ComicsMapperResponse() {
    init();
  }

  private void init() {
    comicMapperResponse = new ComicMapperResponse();
  }

  @Override
  public List<MarvelComic> map(ComicsResponse comicsResponse) {
    List<MarvelComic> marvelComics = new ArrayList<>();
    for (RequestResponse result : comicsResponse.getData().getResults()) {
      MarvelComic mappedMarvelComic = comicMapperResponse.map(result);
      marvelComics.add(mappedMarvelComic);
    }
    return marvelComics;
  }
}
