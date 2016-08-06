package com.fivelabs.marvelsuperhero.app.navigator;

import android.app.Activity;

/**
 * Created by breogangf on 6/8/16.
 */
public interface Navigator {

  Activity getmActivity();
  void loadActivity(Activity activity);
  void loadDetailView(int comicId);
}
