package com.hp.android.noteapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hp.android.noteapp.model.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)
    @Update
    suspend fun updateNote(note: Note)
    @Delete
    suspend fun deleteNote(note: Note)
    @Query("select * from note_table")
    fun getAllNote(): LiveData<List<Note>>

    @Query("select * from note_table where id_col =:id")
    fun getNoteWithId(id: Int): Note
}