package com.fivelabs.marvelsuperhero.ui.presenter;

import com.fivelabs.marvelsuperhero.domain.model.MarvelComic;
import com.fivelabs.marvelsuperhero.domain.repository.BaseRepository;
import com.fivelabs.marvelsuperhero.ui.view.ComicFragment;

/**
 * Created by breogangf on 6/8/16.
 */
public class ComicDetail extends AppBase<ComicFragment> {

    private BaseRepository baseRepository;

    public ComicDetail(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public void onViewReady() {
        super.onViewReady();
        view.showError();
    }

    private int calculateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private String getRandomImage(MarvelComic marvelComic) {
        int number = calculateRandomNumber(0, marvelComic.getImagesUrls().size() - 1);
        return marvelComic.getImagesUrls().get(number);
    }

    public void onComicIdAvailable(int comicId) {
        view.clearError();
        MarvelComic marvelComic = baseRepository.findById(comicId);
        view.prensentInfo(marvelComic);
        if (marvelComic.getImagesUrls().size() > 0) {
            view.presentImage(getRandomImage(marvelComic));
        } else {
            view.presentImage(marvelComic.getThumbnailUrl());
        }
    }


}
