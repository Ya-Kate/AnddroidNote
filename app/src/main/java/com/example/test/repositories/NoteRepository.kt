package com.example.test.repositories

import com.example.test.model.Note
import com.example.test.singlton.SingletonNotes

class NoteRepository {

      suspend fun addNone(note: Note) {
        SingletonNotes.db.noteDao().insertNote(note)
    }

      fun getListNotes() :ArrayList<Note> {
        return SingletonNotes.db.noteDao().selectAllNote() as ArrayList<Note>
    }

    suspend fun deletAllNote() {
        SingletonNotes.db.noteDao().deletAllNote()
    }


}