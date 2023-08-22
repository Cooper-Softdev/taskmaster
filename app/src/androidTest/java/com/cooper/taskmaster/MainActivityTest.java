package com.cooper.taskmaster;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void displayingUIElementsTest() {
        onView(withId(R.id.usernameTasksTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.MainActivityAddTaskButton)).check(matches(isDisplayed()));
        onView(withId(R.id.MainActivityAllTasksButton)).check(matches(isDisplayed()));
    }

    @Test
    public void taskDescriptionTest() {
        onView(withText("TEST: Task Name"))
                .check(matches(isDisplayed()))
                .perform(click());

        onView(withId(R.id.TaskDetailPageHeading))
                .check(matches(withText("TEST: Task Name Test")));
    }

    @Test
    public void editUsernameTest() {
        onView(withId(R.id.MainActivitySettingsButton)).perform(click());

        onView(withId(R.id.SettingsUsernameInputForm))
                .perform(clearText(), typeText("TEST:NewUsername"), closeSoftKeyboard());

        onView(withId(R.id.SettingsAddButton)).perform(click());

        pressBack();

        onView(withId(R.id.usernameTasksTextView))
                .check(matches(withText("TEST:NewUsername's Tasks")));
    }
}

