package com.fivelabs.marvelsuperhero.domain.mapper;

import com.fivelabs.marvelsuperhero.data.model.Date;
import com.fivelabs.marvelsuperhero.data.model.Image;
import com.fivelabs.marvelsuperhero.data.model.RequestResponse;
import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by breogangf on 6/8/16.
 */
public class ComicMapperResponse implements Mapper<RequestResponse, MarvelComic> {

  @Override
  public MarvelComic map(RequestResponse result) {
    MarvelComic marvelComic = new MarvelComic();
    try {
      marvelComic.setYear(getYear(result));
      marvelComic.setTitle(getTitle(result));
      marvelComic.setThumbnailUrl(getThumbnail(result));
      marvelComic.setId(getId(result));
      marvelComic.setImagesUrls(getImages(result));
      marvelComic.setDescription(getDescription(result));

    } catch (DataException e) {

    }
    return marvelComic;
  }

  private String getTitle(RequestResponse result) throws DataException {
    if (result.getTitle() != null) {
      return result.getTitle();
    } else {
      throw new DataException();
    }
  }

  private String getThumbnail(RequestResponse result) throws DataException {
    return result.getThumbnail().getPath() + "." + result.getThumbnail().getExtension();
  }

  private String getDescription(RequestResponse result) throws DataException {
    return result.getDescription();
  }

  private int getId(RequestResponse result) {
    return Integer.valueOf(result.getId());
  }

  private String getYear(RequestResponse result) throws DataException {
    for (Date date : result.getDates()) {
      if ("onsaleDate".equals(date.getType())) {
        return date.getDate().substring(0, 4);
      }
    }
    throw new DataException();
  }

  private List<String> getImages(RequestResponse result) {
    List<String> images = new ArrayList<>();
    for (Image image : result.getImages()) {
      images.add(image.getPath() + "." + image.getExtension());
    }
    return images;
  }

}
