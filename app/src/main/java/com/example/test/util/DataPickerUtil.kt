package com.example.test.util

import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

private const val SIMPLE_DATE_FORMAT = "dd.MM.yyyy"


    fun getData(picker: DatePicker): String {
        val calendar = Calendar.getInstance()
        calendar[picker.year, picker.month] = picker.dayOfMonth

        val sdf = SimpleDateFormat("dd.MM.yyyy")
        return sdf.format(calendar.time)
    }
