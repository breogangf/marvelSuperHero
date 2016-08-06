package com.fivelabs.marvelsuperhero.ui.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.fivelabs.marvelsuperhero.R;
import com.fivelabs.marvelsuperhero.app.CustomActivity;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.Application;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.ComponentProvider;
import com.fivelabs.marvelsuperhero.app.dependencyinjection.CustomView;
import com.fivelabs.marvelsuperhero.ui.presenter.AppBase;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by breogangf on 6/8/16.
 */
public class MainActivity extends CustomActivity {

    @Inject
    protected com.fivelabs.marvelsuperhero.ui.presenter.Home home;

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;
    @Bind(R.id.comics_frame)
    protected FrameLayout comicsFrameLayout;


    public void showDetailView(int comicId) {
        ComicFragment comicFragment = ComicFragment.newInstance(comicId);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.details_frame, comicFragment)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void showComicList() {
        ComicList comicList = ComicList.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.comics_frame, comicList).commit();
    }


    @Override
    public CustomView bindViewComponent() {
        Application application = ((com.fivelabs.marvelsuperhero.app.Main) getApplication()).getApplication();
        return ComponentProvider.getMainViewComponent(application);
    }

    @Override
    public AppBase bindPresenter() {
        return home;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void onViewReady() {
        super.onViewReady();
        home.onViewReady();

        if ("V11-portrait".equals(view.getTag())) {
            home.onPortrait();
        } else {
            home.onLandScape();
        }
    }


}
