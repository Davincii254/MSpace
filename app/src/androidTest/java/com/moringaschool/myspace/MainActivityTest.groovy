package com.moringaschool.myspace


import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4.class)
class MainActivityTest {


    @Rule
    public ActivityTestRule<SatelliteActivity> activityTestRule =
            new ActivityTestRule<>(SatelliteActivity.class);

}
