package com.cookandroid.todolist.category.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.cookandroid.todolist.todo.db.TodoEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM cate_table")
    fun getAllData() : List<CategoryEntity>

    @Query("SELECT title FROM cate_table")
    fun getTitleData() : List<String>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text : CategoryEntity)

    @Update
    fun update(text : CategoryEntity)

    @Delete
    fun delete(text : CategoryEntity)

}