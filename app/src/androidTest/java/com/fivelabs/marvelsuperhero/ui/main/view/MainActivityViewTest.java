package com.fivelabs.marvelsuperhero.ui.main.view;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import com.fivelabs.marvelsuperhero.R;
import com.fivelabs.marvelsuperhero.ui.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by breogangf on 6/8/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityViewTest {

  @Rule public ActivityTestRule<MainActivity> mActivityRule =
      new ActivityTestRule<>(MainActivity.class);

  @Test
  public void testIfInPortraitModeTheFrameIsShowing() throws InterruptedException {
    onView(withId(R.id.comics_frame)).check(matches(isDisplayed()));
  }

  @Test
  public void testIfScrollGetsMoreComics() throws InterruptedException {
    wait(5);
    onView(withId(R.id.comics_list)).perform(RecyclerViewActions.scrollToPosition(10));
    wait(2);
    onView(withId(R.id.comics_list)).perform(
        RecyclerViewActions.actionOnItemAtPosition(11, click()));
    wait(2);
    onView(withId(R.id.comic_info_frame)).check(matches(isDisplayed()));
  }

  private void wait(int seconds) throws InterruptedException {
    Thread.sleep(seconds * 1000);
  }
}
