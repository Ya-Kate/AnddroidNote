package com.example.test.ui.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.model.Note
import com.example.test.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private var noteAddeed: (() -> Unit)? = null

    fun addNote(title: String, message: String, date: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNone(Note(0, title, message, date))
            noteAddeed?.invoke()
        }
    }
}