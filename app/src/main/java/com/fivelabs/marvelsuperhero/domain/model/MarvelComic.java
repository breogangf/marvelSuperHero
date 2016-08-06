package com.fivelabs.marvelsuperhero.domain.model;

import java.util.List;

/**
 * Created by breogangf on 6/8/16.
 */
public class MarvelComic {

  private String title;
  private int id;
  private String description;
  private List<String> imagesUrls;
  private String pages;
  private String thumbnailUrl;
  private String year;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getImagesUrls() {
    return imagesUrls;
  }

  public void setImagesUrls(List<String> imagesUrls) {
    this.imagesUrls = imagesUrls;
  }

  public String getPages() {
    return pages;
  }

  public void setPages(String pages) {
    this.pages = pages;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
}
