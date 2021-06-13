package com.alfian.moviecatalogue.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.alfian.moviecatalogue.R
import com.alfian.moviecatalogue.utils.DataDummy
import com.alfian.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class ListFilmActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(ListFilmActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.duration)).check(matches(isDisplayed()))
        onView(withId(R.id.duration)).check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.rating)).check(matches(isDisplayed()))
        onView(withId(R.id.rating)).check(matches(withText(dummyMovie[0].rating.toString())))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(withText(dummyMovie[0].description)))
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.duration)).check(matches(isDisplayed()))
        onView(withId(R.id.duration)).check(matches(withText(dummyTvShow[0].duration)))
        onView(withId(R.id.rating)).check(matches(isDisplayed()))
        onView(withId(R.id.rating)).check(matches(withText(dummyTvShow[0].rating.toString())))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(withText(dummyTvShow[0].description)))
    }

    @Test
    fun loadFavorites() {

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.favorite_film)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite_film)).perform(click())
        onView(withId(R.id.rv_favorite_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.favorite_film)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.favorite_film)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite_film)).perform(click())
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_favorite_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_favorite_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.favorite_film)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

    }

}