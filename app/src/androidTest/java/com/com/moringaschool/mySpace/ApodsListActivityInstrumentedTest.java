package com.com.moringaschool.mySpace;

import androidx.test.rule.ActivityTestRule;

import com.moringaschool.myspace.R;
import com.moringaschool.myspace.ui.ApodsListActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.moringaschool.myspace.models.Apods.date;

public class ApodsListActivityInstrumentedTest {
    @Rule
    public ActivityTestRule<ApodsListActivity> activityTestRule = new ActivityTestRule<>(ApodsListActivity.class);

    @Test
    public void validateEditText(){
        onView(withId(R.id.Date)).perform(typeText("today"))
                .check(matches(withText("today")));
    }
    @Test
    public void dateIsSentToApodsListActivity(){
        String date = "today";
        onView(withId(R.id.Date)).perform(typeText(date)).perform(closeSoftKeyboard());
        try {
            Thread.sleep(250);
        } catch (InterruptedException e){
            System.out.println("got interrupted!");
        }
        onView(withId(R.id.btnSubmit1)).perform(click());
        onView(withId(R.id.date)).check(matches
                (withText(date)));
    }
}
