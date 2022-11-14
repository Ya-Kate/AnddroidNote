package com.example.test.ui.listnote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.model.Note
import com.example.test.repositories.NoteRepository
import com.example.test.singlton.SingletonNotes

class ListViewModel : ViewModel() {

    private val repository = NoteRepository()

    val listNotes = MutableLiveData<ArrayList<Note>>()

    fun getList() {
        listNotes.value = repository.getListNotes()
    }

    val searchResult = MutableLiveData<ArrayList<Note>>()

    fun searchNote(searchText: String) {
        searchResult.value = SingletonNotes.arrayNotes.filter {
            it.title.contains(searchText) || it.message.contains(searchText)
        } as ArrayList<Note>
    }
}