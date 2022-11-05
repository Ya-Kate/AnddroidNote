package com.example.test.singlton

import com.example.test.model.Note

object SingletonNotes {
    val arrayNotes = arrayListOf<Note>()
    var startActivity:Boolean = false
}