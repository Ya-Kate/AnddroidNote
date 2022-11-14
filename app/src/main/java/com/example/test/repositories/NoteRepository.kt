package com.example.test.repositories

import com.example.test.model.Note
import com.example.test.singlton.SingletonNotes

class NoteRepository {

    fun addNone(note: Note) {
        SingletonNotes.arrayNotes.add(note)
    }

    fun getListNotes() :ArrayList<Note> {
        return SingletonNotes.arrayNotes
    }


}