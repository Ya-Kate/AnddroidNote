package com.example.test.util

import android.widget.DatePicker
import java.util.*

fun getData(picker: DatePicker): Long {
    val calendar = Calendar.getInstance()
    calendar[picker.year, picker.month] = picker.dayOfMonth
    return calendar.timeInMillis
}
