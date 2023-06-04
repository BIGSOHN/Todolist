package com.cookandroid.todolist.category.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cate_table")
data class CategoryEntity (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name="id")
        var cateID : Int,
        @ColumnInfo(name = "title")
        var cateName :String
        )