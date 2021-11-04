package com.hp.android.noteapp.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hp.android.noteapp.R
import com.hp.android.noteapp.model.Note
import com.hp.android.noteapp.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {
    private val noteViewMode: NoteViewModel by lazy {
        ViewModelProvider(
            this, NoteViewModel.NoteViewModelFactory(this.application)
        ).get(NoteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        noteViewMode.getAllNote().observe(this, Observer {
            // update UI, vi nhu set adapter cho recycler view
            Log.d("HuynhPVd", "init: " + it)
        })
    }

    fun addNote(view: View) {
        val note = Note("title test", "content")
        noteViewMode.insertNote(note)
    }
}