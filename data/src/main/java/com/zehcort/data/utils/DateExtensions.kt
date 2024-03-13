package com.zehcort.data.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun String.toDate(): String {
    val inputDatePattern = "yyyy-MM-dd HH:mm:ss"
    val outputDatePattern = "EEEE, MMMM d"
    val inputFormatter = DateTimeFormatter.ofPattern(inputDatePattern)
    val outputFormatter = DateTimeFormatter.ofPattern(outputDatePattern)

    return try {
        LocalDate
            .parse(this, inputFormatter)
            .format(outputFormatter)
    } catch (ex: DateTimeParseException) {
        ""
    }
}

fun String.toTime(): String {
    val inputDatePattern = "yyyy-MM-dd HH:mm:ss"
    val outputDatePattern = "HH:mm"
    val inputFormatter = DateTimeFormatter.ofPattern(inputDatePattern)
    val outputFormatter = DateTimeFormatter.ofPattern(outputDatePattern)

    return try {
        LocalDateTime
            .parse(this, inputFormatter)
            .format(outputFormatter)
    } catch (ex: DateTimeParseException) {
        ""
    }
}