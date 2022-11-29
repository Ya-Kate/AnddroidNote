package com.example.test.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Note(
    @PrimaryKey (autoGenerate = true)
    val id:Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "messag")
    var message: String,

    @ColumnInfo(name = "nowData")
    val nowData: Long
)