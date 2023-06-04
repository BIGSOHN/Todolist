package com.cookandroid.todolist.category.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.cookandroid.todolist.R
import com.cookandroid.todolist.databinding.ActivityCalenderBinding

class Calender : AppCompatActivity() {

    private lateinit var binding : ActivityCalenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_calender)

        binding.back1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}