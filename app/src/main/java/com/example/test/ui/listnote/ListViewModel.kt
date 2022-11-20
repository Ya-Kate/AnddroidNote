package com.example.test.ui.listnote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.model.Note
import com.example.test.repositories.NoteRepository
import com.example.test.singlton.SingletonNotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val repository = NoteRepository()

    val listNotes = MutableLiveData<ArrayList<Note>>()

    val countNotes = MutableLiveData<Int> ()

    val searchResult = MutableLiveData<ArrayList<Note>>()

     fun getList() {
//         Если раскоментировать ошибка, в адаптере мы вызываем getListNotes()..
//         А функция :fun getListNotes() в репозитории, а там т олько можно поставить слово :suspend
//         (типо ModelScope не ставится)
//
//         viewModelScope.launch(Dispatchers.IO){
             listNotes.postValue(repository.getListNotes())
//         }
    }

    fun deletAllNotes() {
        viewModelScope.launch (Dispatchers.IO){
            repository.deletAllNote()
            countNotes.postValue(0)

//            listNotes.postValue(repository.getListNotes())
        }
    }


    fun searchNote(searchText: String) {
        viewModelScope.launch  (Dispatchers.IO) {
            searchResult.value = SingletonNotes.db.noteDao().selectAllNote().filter {
                it.title.contains(searchText) || it.message.contains(searchText)
            } as ArrayList<Note>
        }

    }
}