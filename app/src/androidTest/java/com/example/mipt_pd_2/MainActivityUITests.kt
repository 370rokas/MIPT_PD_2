package com.example.mipt_pd_2

import org.junit.Rule
import org.junit.Test

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.Matchers.`is`


class MainActivityUITests {

    @get:Rule
    val activityScenarioRule = ActivityTestRule(MainActivity::class.java)

    // https://developer.android.com/training/testing/espresso/lists
    private fun selectType(type: String) {
        onView(withId(R.id.typeSelector)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`(type))).perform(click())
    }

    private fun resultString(count: Int): String =
        activityScenarioRule.activity.getString(R.string.result, count)

    @Test
    fun testWhenSentencesAreCountedInInputText() {
        val givenString = "Labas. Didelis krabas."
        val expectedResult = resultString(2)

        onView(withId(R.id.inputText)).perform(click(), replaceText(givenString))
        selectType("Sakiniai")
        onView(withId(R.id.calculateBtn)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText(expectedResult)))
    }

    @Test
    fun testWhenWordsAreCountedInInputText() {
        val givenString = "Labas, didelis krabai."
        val expectedResult = resultString(3)

        onView(withId(R.id.inputText)).perform(click(), replaceText(givenString))
        selectType("Žodžiai")
        onView(withId(R.id.calculateBtn)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText(expectedResult)))
    }

    @Test
    fun testWhenPunctuationIsCountedInInputText() {
        val givenString = "Labas,  krabai."
        val expectedResult = resultString(4)

        onView(withId(R.id.inputText)).perform(click(), replaceText(givenString))
        selectType("Skyryba")
        onView(withId(R.id.calculateBtn)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText(expectedResult)))
    }

    @Test
    fun testWhenNumbersAreCountedInInputText() {
        val givenString = "Labas 25 krabai."
        val expectedResult = resultString(2)

        onView(withId(R.id.inputText)).perform(click(), replaceText(givenString))
        selectType("Skaičiai")
        onView(withId(R.id.calculateBtn)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText(expectedResult)))
    }

    @Test
    fun testWhenEmptyStringIsEnteredToInputText() {
        val givenString = ""
        val expectedResult = ""

        onView(withId(R.id.inputText)).perform(click(), replaceText(givenString))
        onView(withId(R.id.calculateBtn)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText(expectedResult)))
    }

    @Test
    fun testWhenOnlySpacesAreEnteredToInputText() {
        val givenString = "     "
        val expectedResult = ""

        onView(withId(R.id.inputText)).perform(click(), replaceText(givenString))
        onView(withId(R.id.calculateBtn)).perform(click())
        onView(withId(R.id.resultText)).check(matches(withText(expectedResult)))
    }
}