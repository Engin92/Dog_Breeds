package Dog_Breeds.data.activity

import Dog_Breeds.data.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DetailedViewActivityTestEspresso {    //Navigation Tests and TextView-Tests of this class, are already includedd in MainActivityTestEspresso!

    @get: Rule
    val activityRule = ActivityScenarioRule(DetailedViewActivity::class.java)

    @Test
    fun test_isActivityInView() {
        onView(withId(R.id.detailed)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibilityOfAllTextViewsAndLayout() {
        onView(withId(R.id.breedRecyclerView)).check(matches(isDisplayed()))
    }
}