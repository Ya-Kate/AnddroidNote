package com.example.test.ui.addnote

import androidx.lifecycle.ViewModel
import com.example.test.model.Note
import com.example.test.repositories.NoteRepository
import com.example.test.singlton.SingletonNotes

class AddNoteViewModel : ViewModel() {

    private val repository = NoteRepository()

    var noteAddeed:(()->Unit)? = null

    fun addNote(title: String, message: String, data: String) {
        SingletonNotes.arrayNotes.add(Note(title, message, data))
        noteAddeed?.invoke()
    }
}