package com.cookandroid.todolist.category.db

import android.content.Context
import com.cookandroid.todolist.todo.db.TodoEntity

class CateRepository(context : Context) {

    private val cateDB = CategoryDatabase.getDatabase(context)

    fun getCateList() = cateDB.categoryDao().getAllData()

    fun getTitleData() = cateDB.categoryDao().getTitleData()

    fun insertCateData(text: String) = cateDB.categoryDao().insert(CategoryEntity(0, text))

    fun updateData(text: String) = cateDB.categoryDao().update(CategoryEntity(0, text))

}