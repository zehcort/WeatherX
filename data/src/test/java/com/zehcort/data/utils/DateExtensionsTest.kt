package com.zehcort.data.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DateExtensionsTest {

    @Test
    fun validStringToDate() {
        // GIVEN - A valid string date
        val stringDate = "2024-03-13 00:00:00"

        // WHEN - Converting String to readable date
        val localDate = stringDate.toDate()

        // THEN - The converted date object contains the expected values
        assertThat(localDate).isEqualTo("Wednesday, March 13")
    }

    @Test
    fun invalidStringToDate() {
        // GIVEN - An invalid string date
        val stringDate = "2024-03-13"

        // WHEN - Converting String to readable date
        val localDate = stringDate.toDate()

        // THEN - The converted date object contains the expected values
        assertThat(localDate).isEqualTo("")
    }

    @Test
    fun validStringToTime() {
        // GIVEN - A valid string date
        val stringDate = "2024-03-13 09:00:00"

        // WHEN - Converting String to time
        val time = stringDate.toTime()

        // THEN - The converted date object contains the expected values
        assertThat(time).isEqualTo("09:00")
    }

    @Test
    fun invalidStringToTime() {
        // GIVEN - A valid string date
        val stringDate = "09:00:00"

        // WHEN - Converting String to time
        val time = stringDate.toTime()

        // THEN - The time string contains the expected values
        assertThat(time).isEqualTo("")
    }
}