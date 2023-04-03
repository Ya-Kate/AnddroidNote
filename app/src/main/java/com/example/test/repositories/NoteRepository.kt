package com.example.test.repositories
import com.example.test.db.NoteDao
import com.example.test.model.Note
import javax.inject.Inject


class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun addNone(note: Note) {
        noteDao.insertNote(note)
    }

    suspend fun getListNotes(): ArrayList<Note> {
        return noteDao.selectAllNote() as ArrayList<Note>
    }

    suspend fun deletAllNote() {
        noteDao.deletAllNote()
    }
}