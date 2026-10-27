package com.example.mipt_pd_2

import org.junit.Test;
import org.junit.Assert.assertEquals

class CalculatorTests {
    // Sakiniu testai

    @Test
    fun Given_EmptyString_When_sentencesIsCalled_Then_ZeroIsReturned() {
        var calculator = Calculator()
        val givenString = ""

        val expectedResult = 0
        val actualResult = calculator.sentences(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_TextWithoutDots_When_sentencesIsCalled_Then_ZeroIsReturned() {
        var calculator = Calculator()
        val givenString = "Labas krabas"

        val expectedResult = 0
        val actualResult = calculator.sentences(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_TwoSentences_When_sentencesIsCalled_Then_TwoIsReturned() {
        var calculator = Calculator()
        val givenString = "Labas. Krabas."

        val expectedResult = 2
        val actualResult = calculator.sentences(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_TextWithTritaskis_When_sentencesIsCalled_Then_EachDotIsCounted() {
        var calculator = Calculator()
        val givenString = "Labas krabas..."

        val expectedResult = 3
        val actualResult = calculator.sentences(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    // Zodziu testai

    @Test
    fun Given_EmptyString_When_wordsIsCalled_Then_ZeroIsReturned() {
        var calculator = Calculator()
        val givenString = ""

        val expectedResult = 0
        val actualResult = calculator.words(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_StringOfOnlySeparators_When_wordsIsCalled_Then_ZeroIsReturned() {
        var calculator = Calculator()
        val givenString = "  , . "

        val expectedResult = 0
        val actualResult = calculator.words(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_SingleWord_When_wordsIsCalled_Then_OneIsReturned() {
        var calculator = Calculator()
        val givenString = "Labas"

        val expectedResult = 1
        val actualResult = calculator.words(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_SentenceWithPunctuation_When_wordsIsCalled_Then_WordCountIsReturned() {
        var calculator = Calculator()
        val givenString = "Labas, krabas."

        val expectedResult = 2
        val actualResult = calculator.words(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_TextWithMultipleSpaces_When_wordsIsCalled_Then_EmptyPartsAreIgnored() {
        var calculator = Calculator()
        val givenString = "Labas     rytas"

        val expectedResult = 2
        val actualResult = calculator.words(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_WordsSeparatedWithoutSpaces_When_wordsIsCalled_Then_AllWordsAreCounted() {
        var calculator = Calculator()
        val givenString = "a,b.c d"

        val expectedResult = 4
        val actualResult = calculator.words(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_TextWithNumber_When_wordsIsCalled_Then_NumberIsCountedAsWord() {
        var calculator = Calculator()
        val givenString = "Labas 5 krabai."

        val expectedResult = 3
        val actualResult = calculator.words(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    // Skyrybos testai

    @Test
    fun Given_EmptyString_When_punctuationIsCalled_Then_ZeroIsReturned() {
        var calculator = Calculator()
        val givenString = ""

        val expectedResult = 0
        val actualResult = calculator.punctuation(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_TextWithoutPunctuation_When_punctuationIsCalled_Then_ZeroIsReturned() {
        var calculator = Calculator()
        val givenString = "Labas"

        val expectedResult = 0
        val actualResult = calculator.punctuation(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_SentenceWithSpacesCommasAndDots_When_punctuationIsCalled_Then_AllAreCounted() {
        var calculator = Calculator()
        val givenString = "Labas,  krabas."   // ',' = 1, ' ' = 2, '.' = 1

        val expectedResult = 4
        val actualResult = calculator.punctuation(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    // Skaiciu testai

    @Test
    fun Given_EmptyString_When_numbersIsCalled_Then_ZeroIsReturned() {
        var calculator = Calculator()
        val givenString = ""

        val expectedResult = 0
        val actualResult = calculator.numbers(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_AllLettersString_When_numbersIsCalled_Then_ZeroIsReturned() {
        var calculator = Calculator()
        val givenString = "Labas rytas"

        val expectedResult = 0
        val actualResult = calculator.numbers(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_AlphanumericString_When_numbersIsCalled_Then_DigitCountIsReturned() {
        var calculator = Calculator()
        val givenString = "Labas 25 krabai."

        val expectedResult = 2
        val actualResult = calculator.numbers(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun Given_DateString_When_numbersIsCalled_Then_OnlyDigitsAreCounted() {
        var calculator = Calculator()
        val givenString = "2026-10-27"

        val expectedResult = 8
        val actualResult = calculator.numbers(givenString).toInt()

        assertEquals(expectedResult, actualResult)
    }
}