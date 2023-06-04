package com.cookandroid.todolist.todo.db

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cookandroid.todolist.category.db.CateRepository
import com.cookandroid.todolist.category.db.CategoryDatabase
import com.cookandroid.todolist.category.db.CategoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val todoDB = CategoryDatabase.getDatabase(context)

    private var _todoList = MutableLiveData<List<TodoEntity>>()
    val todoList : LiveData<List<TodoEntity>>
        get() = _todoList

    val todoRepository = TodoRepository(context)

    fun getItemData(position : Int) {

    }

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        _todoList.postValue(todoRepository.getCateList())
    }

    fun getCate1Data() = viewModelScope.launch(Dispatchers.IO) {
        _todoList.postValue(todoRepository.getCate1List())
    }

    fun getCate2Data() = viewModelScope.launch(Dispatchers.IO) {
        _todoList.postValue(todoRepository.getCate2List())
    }

    fun getCate3Data() = viewModelScope.launch(Dispatchers.IO) {
        _todoList.postValue(todoRepository.getCate3List())
    }

    fun getCate4Data() = viewModelScope.launch(Dispatchers.IO) {
        _todoList.postValue(todoRepository.getCate4List())
    }

    fun getCate5Data() = viewModelScope.launch(Dispatchers.IO) {
        _todoList.postValue(todoRepository.getCate5List())
    }

    fun insertData(title : String, date : String, check : Boolean, category : Int, priority : String) = viewModelScope.launch(Dispatchers.IO) {
        todoRepository.insertCateData(title, date, check, category, priority)
    }

    fun updateData(title : String, date : String, check : Boolean, category : Int, priority: String) = viewModelScope.launch(Dispatchers.IO) {
        todoRepository.updateData(title, date, check, category, priority)
    }

    fun deleteCate1Data() = viewModelScope.launch {
        todoRepository.deleteCate1Data()
    }

}