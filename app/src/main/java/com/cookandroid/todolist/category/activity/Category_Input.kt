package com.cookandroid.todolist.category.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.cookandroid.todolist.R
import com.cookandroid.todolist.category.db.CategoryDatabase
import com.cookandroid.todolist.category.db.CategoryViewModel

class Category_Input : AppCompatActivity() {

    lateinit var viewmodel : CategoryViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_input)

        viewmodel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        val cateDB = CategoryDatabase.getDatabase(this)

        val cate_input = findViewById<EditText>(R.id.category_input)
        val complete = findViewById<ImageView>(R.id.check_category)
        val cancel = findViewById<ImageView>(R.id.back1)

        complete.setOnClickListener {
            viewmodel.insertData(cate_input.text.toString())

            val intent = Intent(this, Content_Category::class.java)
            startActivity(intent)
        }

        cancel.setOnClickListener {

            val intent = Intent(this, Content_Category::class.java)
            startActivity(intent)

        }

    }
}