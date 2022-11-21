package com.example.test.singlton

import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

object SingletonStringData {
    fun getData(picker: DatePicker): String {
        val day: Int = picker.getDayOfMonth()
        val month: Int = picker.getMonth()
        val year: Int = picker.getYear()
        val calendar = Calendar.getInstance()
        calendar[year, month] = day

        val sdf = SimpleDateFormat("dd.MM.yyyy")
        val formatedDate = sdf.format(calendar.time)

        return formatedDate
    }
}