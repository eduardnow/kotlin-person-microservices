package tech.eduardnow.personms.domain

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

sealed class Utils {

    companion object {
        fun dateToString(dateTime: LocalDateTime): String = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE)
    }

}
