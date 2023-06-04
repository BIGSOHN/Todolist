package com.cookandroid.todolist.todo.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.io.ByteArrayOutputStream
import java.util.Date


@Entity(tableName = "todo_table")
data class TodoEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var todoID : Int,
    @ColumnInfo(name = "title")
    var todoTitle : String,
    @ColumnInfo(name = "date")
    var todoDate : String,
    @ColumnInfo(name = "checked")
    var todoCheck : Boolean = false,
    @ColumnInfo(name = "category")
    var todoCategory : Int,
    @ColumnInfo(name = "priority")
    var todoPriority : String,


)

//class DateTypeConvert {
//
//    // Long -> Date
//    @TypeConverter
//    fun toDate(value: Long?): Date? {
//        return value?.let { Date(it) }
//    }
//
//    // Date -> Long
//    @TypeConverter
//    fun toLong(date : Date?): Long? {
//        return date?.time?.toLong()
//    }
//}