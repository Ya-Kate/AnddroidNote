package com.example.test.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.test.model.Note
//import com.example.test.util.DateConverter

@Database (entities = [Note::class], version = 1)
//@TypeConverters(DateConverter::class)

abstract class AppDataBase :RoomDatabase() {
    abstract fun noteDao() :NoteDao
}