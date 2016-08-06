package com.fivelabs.marvelsuperhero.app.dependencyinjection;

import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by breogangf on 6/8/16.
 */
@Scope @Retention(RUNTIME) public @interface CView {
}
