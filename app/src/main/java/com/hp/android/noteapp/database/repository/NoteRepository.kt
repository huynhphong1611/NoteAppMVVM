package com.hp.android.noteapp.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.hp.android.noteapp.database.NoteDatabase
import com.hp.android.noteapp.database.dao.NoteDao
import com.hp.android.noteapp.model.Note

class NoteRepository(app: Application) {
    private val noteDao : NoteDao
    init {
        val noteDatabase: NoteDatabase = NoteDatabase.getInstance(app)
        noteDao = noteDatabase.getNoteDao()
    }
    suspend fun insertNote(note: Note) = noteDao.insertNote(note)
    suspend fun updateNote(note: Note) = noteDao.updateNote(note)
    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
    fun getAllNote():LiveData<List<Note>> = noteDao.getAllNote()
}