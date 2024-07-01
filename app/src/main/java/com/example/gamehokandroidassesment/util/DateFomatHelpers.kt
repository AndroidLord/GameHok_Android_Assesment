package com.example.gamehokandroidassesment.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun monthDayFormat(date: Date): String {
    val format = SimpleDateFormat("MMM dd", Locale.getDefault())
    return format.format(date)
}

fun monthDayYearFormat(date: Date): String {
    val format = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    return format.format(date)
}

fun allDateFormat(date: Date): String {
    val dayFormat = SimpleDateFormat("dd", Locale.getDefault())
    val restFormat = SimpleDateFormat("EEE MMM yyyy, hh:mm a", Locale.getDefault())

    val day = dayFormat.format(date).toInt()
    val daySuffix = when (day) {
        1, 21, 31 -> "st"
        2, 22 -> "nd"
        3, 23 -> "rd"
        else -> "th"
    }

    return "${restFormat.format(date).substring(0, 4)}$day$daySuffix${
        restFormat.format(date).substring(6)
    }"
}

// write a function that takes a Date object and returns how much time is left until that date the format will be day hours minutes
fun timeLeft(date: Date): String {
    val currentTime = System.currentTimeMillis()
    val timeLeft = date.time - currentTime

    val days = timeLeft / (1000 * 60 * 60 * 24)
    val hours = timeLeft / (1000 * 60 * 60) % 24
    val minutes = timeLeft / (1000 * 60) % 60

    return "$days d $hours h $minutes m"
}