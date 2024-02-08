package com.zehcort.data.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.toDate(): String {
    val inputDatePattern = "yyyy-MM-dd HH:mm:ss"
    val outputDatePattern = "EEEE, MMMM d"
    val inputFormatter = DateTimeFormatter.ofPattern(inputDatePattern)
    val outputFormatter = DateTimeFormatter.ofPattern(outputDatePattern)

    return LocalDate
        .parse(this, inputFormatter)
        .format(outputFormatter)
}

fun String.toTime(): String {
    val inputDatePattern = "yyyy-MM-dd HH:mm:ss"
    val outputDatePattern = "HH:mm"
    val inputFormatter = DateTimeFormatter.ofPattern(inputDatePattern)
    val outputFormatter = DateTimeFormatter.ofPattern(outputDatePattern)

    return LocalDateTime
        .parse(this, inputFormatter)
        .format(outputFormatter)
}