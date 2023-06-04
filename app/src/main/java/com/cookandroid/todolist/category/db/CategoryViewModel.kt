package com.cookandroid.todolist.category.db

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val cateDB = CategoryDatabase.getDatabase(context)

    private var _categoryList = MutableLiveData<List<CategoryEntity>>()
    val categoryList : LiveData<List<CategoryEntity>>
        get() = _categoryList

    private var _titleList = MutableLiveData<List<String>>()
    val titleList : LiveData<List<String>>
        get() = _titleList

    val cateRepository = CateRepository(context)

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        _categoryList.postValue(cateRepository.getCateList())
    }

    fun getTitleData() = viewModelScope.launch(Dispatchers.IO){
        _titleList.postValue(cateRepository.getTitleData())
    }
    fun getItemData(position : Int) : String{
        val title = titleList.value
        var size : Int = 0
        if(title == null) {
            size = 0
        }
        else {
            size = title.size
        }
        if(position >= size) {
            return ""
        }
        else {
            return title!!.get(position)
        }
    }

//    fun getTitleListSize() : Int? {
//        val title = titleList.value
//        var size : Int = 0
//        if(title == null) {
//            size = 0
//        }
//        else {
//            size = title.size
//        }
//        Log.d("size", size.toString())
//        if(size != 4) {
//            return titleList.value?.size
//        }
//        else {
//            return 0
//        }
//    }

    fun insertData(text : String) = viewModelScope.launch(Dispatchers.IO) {
        cateRepository.insertCateData(text)
    }

    fun updateData(text : String) = viewModelScope.launch(Dispatchers.IO) {
        cateRepository.updateData(text)
    }

}