package com.cookandroid.todolist.category.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cookandroid.todolist.R
import com.cookandroid.todolist.category.db.CategoryDatabase
import com.cookandroid.todolist.category.db.CategoryViewModel

class Spinner : AppCompatActivity() {
    // 카테고리 선택 spinner
//    private lateinit var cateViewModel : CategoryViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_spinner)
//
//        cateViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
//
//        val cateDB = CategoryDatabase.getDatabase(this)
//
//        lateinit var category : String
//
//        cateViewModel.getTitle()
//        cateViewModel.titleList.observe(this, Observer {
//            var title1 = cateViewModel.getItemData(0)
//            var title2 = cateViewModel.getItemData(1)
//            var title3 = cateViewModel.getItemData(2)
//            var title4 = cateViewModel.getItemData(3)
//            var title5 = cateViewModel.getItemData(4)
//            Log.d("abc", title1)
//            var categorySpinnerList = arrayListOf(title1, title2, title3, title4, title5)
//
//            var adapter =
//                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categorySpinnerList)
//
//            val spinner = findViewById<Spinner>(R.id.spinner)
//            spinner.adapter = adapter
//            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//
//                override fun onItemSelected(
//                    parent: AdapterView<*>?,
//                    view: View?,
//                    position: Int,
//                    id: Long
//                ) {
//                    category = categorySpinnerList.get(position)
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>?) {
//                    Toast.makeText(baseContext, "카테고리를 선택해주세요.", Toast.LENGTH_LONG).show()
//                }
//            }
//        })
//
//    }
}