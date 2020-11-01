package com.moringaschool.myspace;

import android.content.Intent
import com.moringaschool.myspace.LoginActivity
import com.moringaschool.myspace.MainActivity
import com.moringaschool.myspace.SecondActivity
import com.moringaschool.myspace.ui.ApodsListActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowActivity

@RunWith(RobolectricTestRunner.class)
class SecondActivityTest {
    private SecondActivity activity;

    void testOnCreate() {
    }
    @Before
    public void setup(){
        activity = Robolectric.setupActivity(SecondActivity.class);
    }
    @Test
    public void ApodsActivityStarted(){
        activity.findViewById(R.id.btnSubmit1).performClick();
        Intent expectedIntent = new Intent(activity, ApodsListActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
