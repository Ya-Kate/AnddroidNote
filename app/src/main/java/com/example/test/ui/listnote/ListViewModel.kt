package com.example.test.ui.listnote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.model.Note
import com.example.test.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor( private val repository: NoteRepository) : ViewModel() {

    val listNotes = MutableLiveData<ArrayList<Note>>()

    private val countNotes = MutableLiveData<Int> ()

    val searchResult = MutableLiveData<ArrayList<Note>>()

     fun getList() {
         viewModelScope.launch(Dispatchers.IO){
             listNotes.postValue(repository.getListNotes())
         }
    }

    fun getCollNotes(){
        viewModelScope.launch (Dispatchers.IO){
            countNotes.postValue(repository.getListNotes().size)
        }

    }

    fun deletAllNotes() {
        viewModelScope.launch (Dispatchers.IO){
            repository.deletAllNote()
            countNotes.postValue(0)
        }
    }


    fun searchNote(searchText: String) {
        viewModelScope.launch  (Dispatchers.IO) {
//            searchResult.value = listNotes {
//                it.title.contains(searchText) || it.message.contains(searchText)
//            } as ArrayList<Note>
        }

    }
}