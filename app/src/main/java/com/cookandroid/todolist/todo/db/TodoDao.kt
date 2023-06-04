package com.cookandroid.todolist.todo.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.cookandroid.todolist.category.db.CategoryEntity

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table")
    fun getAllData(): List<TodoEntity>

    @Query("SELECT *FROM todo_table WHERE category = 1")
    fun getCate1Data() : List<TodoEntity>

    @Query("SELECT *FROM todo_table WHERE category = 2")
    fun getCate2Data() : List<TodoEntity>

    @Query("SELECT *FROM todo_table WHERE category = 3")
    fun getCate3Data() : List<TodoEntity>

    @Query("SELECT *FROM todo_table WHERE category = 4")
    fun getCate4Data() : List<TodoEntity>

    @Query("SELECT *FROM todo_table WHERE category = 5")
    fun getCate5Data() : List<TodoEntity>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: TodoEntity)

    @Update
    fun update(text: TodoEntity)

    @Update
    suspend fun updateTodoItem(todoItem: TodoEntity)

    @Delete
    fun delete(text: TodoEntity)

    @Query("UPDATE todo_table SET checked = :isChecked WHERE id = :todoId")
    suspend fun updateCheckedStatus(todoId: Int, isChecked: Boolean)

    @Query("SELECT checked FROM todo_table WHERE id = :todoId")
    suspend fun getCheckedStatus(todoId: Int): Boolean

    @Query("DELETE FROM todo_table WHERE category = 1")
    fun deleteCate1Data()

    @Query("DELETE FROM todo_table WHERE category = 2")
    fun deleteCate2Data()

    @Query("DELETE FROM todo_table WHERE category = 3")
    fun deleteCate3Data()

    @Query("DELETE FROM todo_table WHERE category = 4")
    fun deleteCate4Data()

    @Query("DELETE FROM todo_table WHERE category = 5")
    fun deleteCate5Data()

}

