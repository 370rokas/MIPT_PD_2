package com.example.mipt_pd_2

class Calculator {
    fun sentences(text: String): Number {
        return text.count { it == '.' }
    }

    fun words(text: String): Number {
        return text.split(' ', ',', '.').count { it.isNotEmpty() }
    }

    fun punctuation(text: String): Number {
        return text.count { it == ' ' || it == ',' || it == '.' }
    }

    fun numbers(text: String): Number {
        return text.count { it.isDigit() }
    }
}