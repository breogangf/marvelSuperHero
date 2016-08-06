package com.fivelabs.marvelsuperhero.app.navigator;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import com.fivelabs.marvelsuperhero.ui.view.Detail;
import com.fivelabs.marvelsuperhero.ui.view.MainActivity;

/**
 * Created by breogangf on 6/8/16.
 */
public class DefaultNavigator implements Navigator {

  protected Activity mActivity;

  protected void load(Intent intent) {
    mActivity.startActivity(intent);
  }

  public void loadActivity(Activity activity) {
    this.mActivity = activity;
  }

  @Override
  public void loadDetailView(int comicId) {
    int currentOrientation = getmActivity().getResources().getConfiguration().orientation;

    if (mActivity instanceof MainActivity
        && currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
      ((MainActivity) mActivity).showDetailView(comicId);
    } else {
      Intent intent = new Intent(mActivity, Detail.class);
      intent.putExtra("comicId", comicId);
      load(intent);
    }
  }

  public Activity getmActivity() {
    return mActivity;
  }

}
