package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import com.fivelabs.marvelsuperhero.ui.view.ComicFragment;

import dagger.Component;

/**
 * Created by breogangf on 6/8/16.
 */
@Component(dependencies = Application.class, modules = ComicInfoModule.class)
@CView
public interface ComicFields extends CustomView<ComicFragment> {
}
