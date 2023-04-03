package com.example.test.sampleobserver

import com.example.test.model.Note

interface Subscriber {

    fun updete(note: ArrayList<Note>)
}