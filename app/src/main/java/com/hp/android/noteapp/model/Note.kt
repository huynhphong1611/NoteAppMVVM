package com.hp.android.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note (
    @ColumnInfo(name = "title_col") var title:String="",
    @ColumnInfo(name = "content_col") var content: String = "") {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_col")
    var id : Int = 0
}