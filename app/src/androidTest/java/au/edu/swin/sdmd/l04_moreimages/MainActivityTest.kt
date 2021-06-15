package au.edu.swin.sdmd.l04_moreimages


import android.support.test.uiautomator.UiDevice
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testImageChangeOnClick() {
        val materialButton = onView(allOf(withId(R.id.college)))
        materialButton.perform(click())
        val imageView = onView(
            allOf(withId(R.id.imageView), withContentDescription("college")))
        imageView.check(ViewAssertions.matches(isDisplayed()))

    }

    @Test
    fun testImageSaveOnRotation() {
        val materialButton = onView(allOf(withId(R.id.college)))
        materialButton.perform(click())
        var imageView = onView(
            allOf(withId(R.id.imageView), withContentDescription("college")))
        imageView.check(ViewAssertions.matches(isDisplayed()))

        val device: UiDevice = UiDevice.getInstance(getInstrumentation())
        device.setOrientationRight()

        imageView = onView(
            allOf(withId(R.id.imageView), withContentDescription("college")))
        imageView.check(ViewAssertions.matches(isDisplayed()))

    }
}
