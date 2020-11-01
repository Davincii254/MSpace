package com.moringaschool.myspace;

import android.content.Intent
import com.moringaschool.myspace.SecondActivity
import com.moringaschool.myspace.SignUpActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowActivity

@RunWith(RobolectricTestRunner.class)

class SignUpActivityTest {
    private SignUpActivity activity;
    @Before
    public void setup(){
        activity = Robolectric.setupActivity(SignUpActivity.class);
    }
    void testOnCreate() {
    }

    void testIsEmail() {

    }

    void testIsEmpty() {
    }

    void testCheckDataEntered() {
    }
    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.createUserButton).performClick();
        Intent expectedIntent = new Intent(activity, SecondActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
