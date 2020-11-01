package com.moringaschool.myspace;

import android.content.Intent
import com.moringaschool.myspace.LoginActivity
import com.moringaschool.myspace.MainActivity
import com.moringaschool.myspace.SecondActivity
import com.moringaschool.myspace.SignUpActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
class MainActivityTest {
    private MainActivity activity;
    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);
    }
    @Test
    public void LoginActivityStarted(){
        activity.findViewById(R.id.btnSignup).performClick();
        Intent expectedIntent = new Intent(activity, LoginActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
    @Test
    public void SignUpActivityStarted(){
        activity.findViewById(R.id.btnSingin).performClick();
        Intent expectedIntent = new Intent(activity, SignUpActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
