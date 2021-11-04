package com.hp.android.noteapp.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hp.android.noteapp.database.repository.NoteRepository
import com.hp.android.noteapp.model.Note
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class NoteViewModel(app: Application):ViewModel() {
    private val noteRopository: NoteRepository = NoteRepository(app)


    fun insertNote(note: Note) {
        viewModelScope.launch { noteRopository.insertNote(note) }
    }
    fun updateNote(note: Note) {
        viewModelScope.launch { noteRopository.updateNote(note) }
    }
    fun deleteNote(note: Note) {
        viewModelScope.launch { noteRopository.deleteNote(note) }
    }
    fun getAllNote():LiveData<List<Note>> {
        return noteRopository.getAllNote()
    }
    class NoteViewModelFactory(private val app: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
                return NoteViewModel(app) as T
            }
            throw IllegalArgumentException("khong tao duoc NoteViewModel")
        }

    }
}