package com.example.test.util

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun dateFromLong(value: Long) : Date {
        return Date(value)
    }

    @TypeConverter
    fun longFromData(date: Date) :Long {
        return date.time
    }
}