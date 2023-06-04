package com.cookandroid.todolist.todo.db

import android.content.Context
import com.cookandroid.todolist.category.db.CategoryDatabase
import com.cookandroid.todolist.category.db.CategoryEntity
import java.util.Date

class TodoRepository(context : Context) {


    private val todoDB = CategoryDatabase.getDatabase(context)
    private val todoDao = todoDB.todoDao()

    fun getAllTodoData() = todoDao.getAllData()

    fun getCateList() = todoDB.todoDao().getAllData()

    fun getCate1List() = todoDB.todoDao().getCate1Data()

    fun getCate2List() = todoDB.todoDao().getCate2Data()

    fun getCate3List() = todoDB.todoDao().getCate3Data()

    fun getCate4List() = todoDB.todoDao().getCate4Data()

    fun getCate5List() = todoDB.todoDao().getCate5Data()

    fun insertCateData(title : String, date : String, check : Boolean, category : Int, priority : String) = todoDB.todoDao().insert(
        TodoEntity(0, title, date, check, category, priority)
    )

    fun updateData(title : String, date : String, check : Boolean, category : Int, priority: String) = todoDB.todoDao().update(
        TodoEntity(0, title, date, check, category, priority)
    )

    fun deleteCate1Data() = todoDB.todoDao().deleteCate1Data()

    fun deleteCate2Data() = todoDB.todoDao().deleteCate2Data()

    fun deleteCate3Data() = todoDB.todoDao().deleteCate3Data()

    fun deleteCate4Data() = todoDB.todoDao().deleteCate4Data()

    fun deleteCate5Data() = todoDB.todoDao().deleteCate5Data()
}