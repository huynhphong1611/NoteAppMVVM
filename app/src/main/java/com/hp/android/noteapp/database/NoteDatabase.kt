package com.hp.android.noteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hp.android.noteapp.database.NoteDatabase.Companion.VERSION_DATEBASE
import com.hp.android.noteapp.database.dao.NoteDao
import com.hp.android.noteapp.model.Note

@Database(entities = [Note::class], version = VERSION_DATEBASE)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao() : NoteDao
    companion object{
        const val VERSION_DATEBASE = 1
        const val DATABASE_NAME = "note_database"

        var instance : NoteDatabase? = null
        fun getInstance(context: Context) : NoteDatabase{
            if (instance == null) {
                instance = Room.databaseBuilder(context,
                    NoteDatabase::class.java,
                    DATABASE_NAME)
                    .build()
            }
            return instance!!
        }

    }

}