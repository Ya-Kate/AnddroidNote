package com.example.test.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test.model.Note

@Database (entities = [Note::class], version = 1)

abstract class AppDataBase :RoomDatabase() {
    abstract fun noteDao() :NoteDao
}