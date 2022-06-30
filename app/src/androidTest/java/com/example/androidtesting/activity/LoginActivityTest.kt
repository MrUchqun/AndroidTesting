package com.example.androidtesting.activity

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.androidtesting.R
import com.example.androidtesting.Utils.Utils
import org.hamcrest.CoreMatchers.containsString
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    private lateinit var scenario: ActivityScenario<LoginActivity>

    @Before
    fun setup() {
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun loginWithValidCredentials() {
        // type user email
        onView(withId(R.id.et_email)).perform(
            ViewActions.typeText(Utils.USER_NAME),
            ViewActions.closeSoftKeyboard()
        )

        // type user email
        onView(withId(R.id.et_password)).perform(
            ViewActions.typeText(Utils.VALID_PASSWORD),
            ViewActions.closeSoftKeyboard()
        )

        // click login button
        onView(withId(R.id.b_login)).perform(click())

        // check text on textView
        onView(withId(R.id.tv_message)).check(matches(withText(containsString(Utils.VALID_PASSWORD))))
    }
}