package com.example.test.sampleobserver


object Publisher {

//    private val listNote = arrayListOf<Note>()

    private val listSubscriber = arrayListOf<Subscriber>()

    fun subscribe(subscriber: Subscriber) {
        listSubscriber.add(subscriber)
    }

//    fun addNone(note:Note) {
//        listNote.add(note)
//        listSubscriber.forEach{
//            it.updete(listNote)
//        }
//    }
}