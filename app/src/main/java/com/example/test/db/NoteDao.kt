package com.example.test.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.test.model.Note

@Dao
interface NoteDao {
    @Insert
     suspend fun insertNote(note: Note)

    @Delete
     fun deletNote(note: ArrayList<Note>)

    @Query ("SELECT * FROM Note")
     suspend fun selectAllNote(): List<Note>

     @Query ("DELETE FROM Note" )
     suspend fun deletAllNote()
}