package mz.co.vodacom.challenge.epictravelassistant.utils

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat
import java.text.SimpleDateFormat
import java.time.*
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.concurrent.TimeUnit

class DateUtils {

    companion object {
        @JvmStatic
        fun getDateDiffForSecs(millis1: Long = 0L, millis2: Long): Long {
            val diffInMillies = millis2 - millis1
            val secs = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS)
            return if (secs < 0) {
                0
            } else {
                secs
            }
        }

        fun getDateDiffForDays(millis1: Long = 0L, millis2: Long): Long {
            val diffInMillies = millis2 - millis1
            val days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)
            return if (days < 0) {
                0
            } else {
                days
            }
        }

        fun getCurrentUTCTimeFromTZ(timeZone: String?): Long =
            timeZone?.let {
                val zoneId: ZoneId = ZoneId.of(it)
                val zonedDateTime: ZonedDateTime = ZonedDateTime.now(zoneId)

                // Get current UTC time as Instant
                val instant: Instant = zonedDateTime.withZoneSameInstant(ZoneOffset.UTC).toInstant()

                // Convert Instant to milliseconds since Unix epoch
                instant.toEpochMilli()
            } ?: 0L

        fun getDayOfWeekName(dow: Int) = when (dow) {
            1 -> "Mo"
            2 -> "Tu"
            3 -> "We"
            4 -> "Th"
            5 -> "Fr"
            6 -> "Sa"
            7 -> "Su"
            else -> "?"
        }

        fun convertMillisecondsToDate(milliseconds: Long, pattern: String): String {
            val dateTime = DateTime(milliseconds)
            val formatter = DateTimeFormat.forPattern(pattern)
            return dateTime.toString(formatter)
        }

        fun modifyDate(initialDateMillis: Long, unit: ChronoUnit, value: Long): Long {
            val initialInstant = Instant.ofEpochMilli(initialDateMillis)
            val modifiedInstant = initialInstant.plus(value, unit)
            return modifiedInstant.toEpochMilli()
        }

        fun dateToMilliseconds(dateString: String, dateFormatPattern: String): Long {
            val dateFormat = SimpleDateFormat(dateFormatPattern)
            dateFormat.timeZone = TimeZone.getTimeZone("UTC")

            try {
                val date = dateFormat.parse(dateString)
                return date.time
            } catch (e: Exception) {
                e.printStackTrace()
                return -1 // Return -1 to indicate an error
            }
        }

        fun convertTimeInMilliFromTimeZone(milliseconds: Long, timeZoneId: String): DateTime {
            val instant = org.joda.time.Instant(milliseconds)
            val timeZone = DateTimeZone.forID(timeZoneId)
            val dateTime = DateTime(instant, timeZone)
            return dateTime
        }

        fun adjustTimezoneOffset(milliseconds: Long, timeZoneId: String): Int {
            val timeZone = TimeZone.getTimeZone(timeZoneId)
            val offsetMillis = timeZone.getOffset(milliseconds)
            val offsetHours = offsetMillis / 3600000 // Convert milliseconds to hours

            return offsetHours
        }

        fun convertMillisecondsToLocalDate(milliseconds: Long, timeZone: String): LocalDateTime? {
            val instant = Instant.ofEpochMilli(milliseconds)
            return instant.atZone(ZoneId.of(timeZone)).toLocalDateTime()
        }
    }


}