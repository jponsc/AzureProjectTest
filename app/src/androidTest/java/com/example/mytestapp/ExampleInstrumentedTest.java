package com.example.mytestapp;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.core.app.ActivityScenario;
import com.example.mytestapp.ui.login.LoginActivity;

import androidx.test.espresso.Espresso.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> rule = new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void loginOK() {
        ActivityScenario scenario = rule.getScenario();

        onView(withId(R.id.username)).perform(typeText("admin"));
        onView(withId(R.id.password)).perform(typeText("123456"));
        onView(withId(R.id.login)).perform(click());

        onView(withId(R.id.mytextbox)).check(matches(withText("Welcome")));
    }

    @Test
    public void loginKO() {
        ActivityScenario scenario = rule.getScenario();

        onView(withId(R.id.username)).perform(typeText("adminerror"));
        onView(withId(R.id.password)).perform(typeText("123456"));
        onView(withId(R.id.login)).perform(click());

        onView(withId(R.id.username)).check(matches(withText("")));
    }
}