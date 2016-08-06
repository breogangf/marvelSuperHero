package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import dagger.Component;

/**
 * Created by breogangf on 6/8/16.
 */
@Component(dependencies = Application.class, modules = ComicsModule.class)
@CView
public interface ComicList extends CustomView<com.fivelabs.marvelsuperhero.ui.view.ComicList> {

}
