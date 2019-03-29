package android.paging.library.bug.util

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun timestampToDate(timestamp: Long) = Date(timestamp)

    @TypeConverter
    fun dateToTimestamp(date: Date) = date.time

}