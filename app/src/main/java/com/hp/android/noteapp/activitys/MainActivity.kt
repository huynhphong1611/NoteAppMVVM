package com.hp.android.noteapp.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hp.android.noteapp.R
import com.hp.android.noteapp.databinding.ActivityMainBinding
import com.hp.android.noteapp.model.Note
import com.hp.android.noteapp.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {
    private val noteViewModel: NoteViewModel by lazy {
        ViewModelProvider(
            this, NoteViewModel.NoteViewModelFactory(this.application)
        ).get(NoteViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // su dung databinding
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()

        binding.btnAddNote.setOnClickListener {
            val note = Note("title test", "content")
            noteViewModel.insertNote(note)
        }

        binding.btnDeleteNote.setOnClickListener {
            for (note in noteViewModel.getAllNote().value!!) {
                noteViewModel.deleteNote(note)
            }
        }
    }

    private fun init() {
        noteViewModel.getAllNote().observe(this, {
            // update UI, vi nhu set adapter cho recycler view
            Log.d("HuynhPVd", "init: size note " + it.size)
            Log.d("HuynhPVd", "init: " + it)
        })
    }
}