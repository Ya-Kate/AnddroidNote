package com.example.test.ui.listnote

import androidx.lifecycle.ViewModel
import com.example.test.model.Note
import com.example.test.singlton.SingletonNotes

class ListViewModel:ViewModel() {
    fun getList() :ArrayList<Note> {
        return SingletonNotes.arrayNotes
    }
}