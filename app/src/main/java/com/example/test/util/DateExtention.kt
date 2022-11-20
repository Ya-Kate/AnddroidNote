package com.example.test.util

import java.text.SimpleDateFormat
import java.util.*

fun Date.convertToSimpleDate(): String {
    val format = SimpleDateFormat("dd.MM.yyyy")
    return format.format(this)
}
