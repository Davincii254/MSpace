package com.moringaschool.myspace

import android.content.Intent
import com.moringaschool.myspace.LoginActivity
import com.moringaschool.myspace.SecondActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowActivity

@RunWith(RobolectricTestRunner.class)

class LoginActivityTest {
    private LoginActivity activity;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Config(manifest=Config.NONE)
    @Test
    public void passwordValidator_CorrectPasswordSimple_ReturnsTrue(){
        AssertThat(PasswordAuthentication.isValidPasswrord("password")).isTrue();
    }
    @Test
        public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
            assertThat(EmailValidator.isValidEmail("name@email.com")).isTrue();
        }
    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.passwordLoginButton).performClick();
        Intent expectedIntent = new Intent(activity, SecondActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}


