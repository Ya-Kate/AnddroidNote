package com.example.test.ui.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.model.Note
import com.example.test.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class AddNoteViewModel : ViewModel() {

    private val repository = NoteRepository()

    var noteAddeed:(()->Unit)? = null

    fun addNote(title: String, message: String, date:Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNone(Note(0,title, message, date))
            noteAddeed?.invoke()
        }

    }
}