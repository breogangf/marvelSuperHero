package com.fivelabs.marvelsuperhero.app.dependencyinjection;

/**
 * Created by breogangf on 6/8/16.
 */
public final class ComponentProvider {

  private static Home home = null;
  private static Comic comic = null;
  private static ComicList comicList = null;
  private static Detail detail = null;
  private static ComicFields comicFields = null;

  private ComponentProvider() {
  }

  public static Comic getComicComponent(Application application) {
    if (comic == null) {
      comic = DaggerComic.builder()
          .application(application)
          .comicModule(new ComicModule())
          .build();
    }
    return comic;
  }

  public static ComicFields getComicInfoComponent(
      Application application) {
    if (comicFields == null) {
      comicFields = DaggerComicFields.builder()
          .application(application)
          .comicInfoModule(new ComicInfoModule())
          .build();
    }
    return comicFields;
  }

  public static ComicList getComicsComponent(Application application) {
    if (comicList == null) {
      comicList = DaggerComicList.builder()
          .application(application)
          .comicsModule(new ComicsModule())
          .build();
    }
    return comicList;
  }

  public static Detail getDetailViewComponent(
      Application application) {
    if (detail == null) {
      detail = DaggerDetail.builder()
          .application(application)
          .detailViewModule(new DetailViewModule())
          .build();
    }
    return detail;
  }

  public static Home getMainViewComponent(Application application) {
    if (home == null) {
      home = DaggerHome.builder()
          .application(application)
          .mainViewModule(new MainViewModule())
          .build();
    }
    return home;
  }
}