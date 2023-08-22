package com.cooper.taskmaster;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import com.cooper.taskmaster.activities.TaskDetailActivity;
import org.junit.Rule;
import org.junit.Test;

public class TaskDetailActivityTest {

    @Rule
    public ActivityScenarioRule<TaskDetailActivity> activityScenarioRule = new ActivityScenarioRule<>(TaskDetailActivity.class);

    @Test
    public void displayTaskTest() {
        Espresso.onView(ViewMatchers.withId(R.id.TaskDetailPageHeading))
                .check(ViewAssertions.matches(ViewMatchers.withText("Test Task Detail: New Task Details")));
    }
}