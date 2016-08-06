package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.ui.adapter.ComicAdapter;

import dagger.Component;

/**
 * Created by breogangf on 6/8/16.
 */
@Component(dependencies = Application.class, modules = ComicModule.class)
@CView
public interface Comic extends CustomView<ComicAdapter> {
}
