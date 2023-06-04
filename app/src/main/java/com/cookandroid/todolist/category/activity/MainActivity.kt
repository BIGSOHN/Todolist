package com.cookandroid.todolist.category.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cookandroid.todolist.R
import com.cookandroid.todolist.category.db.CategoryDatabase
import com.cookandroid.todolist.category.db.CategoryViewModel
import com.cookandroid.todolist.databinding.ActivityMainBinding
import com.cookandroid.todolist.todo.Todo_Input
import com.cookandroid.todolist.todo.mainfragment.Fragment1
import com.cookandroid.todolist.todo.mainfragment.Fragment2
import com.cookandroid.todolist.todo.mainfragment.Fragment3
import com.cookandroid.todolist.todo.mainfragment.Fragment4
import com.cookandroid.todolist.todo.mainfragment.Fragment5


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var cateViewModel : CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        cateViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        val cateDB = CategoryDatabase.getDatabase(this)

        val view = binding.root
        setContentView(view)

        // 카테고리 관리 클릭 이벤트
        binding.detail1.setOnClickListener {
            val intent = Intent(this, Content_Category::class.java)
            startActivity(intent)
        }
        // 달력 버튼 클릭 이벤트
        binding.calendar.setOnClickListener {
            val intent = Intent(this, Calender::class.java)
            startActivity(intent)
        }
        // 투두 추가 버튼 클릭 이벤트
        binding.todoInsert.setOnClickListener {
            val intent = Intent(this, Todo_Input::class.java)
            startActivity(intent)
        }

        // 카테고리 분류 제목
        var cate1 = binding.textView1
        var cate2 = binding.textView2
        var cate3 = binding.textView3
        var cate4 = binding.textView4
        var cate5 = binding.textView5

        cateViewModel.getTitleData()
        cateViewModel.titleList.observe(this, Observer {
            var title1 = cateViewModel.getItemData(0)
            Log.d("category", title1)
            cate1.setText(title1)

            var title2 = cateViewModel.getItemData(1)
            Log.d("category", title2)
            cate2.setText(title2)

            var title3 = cateViewModel.getItemData(2)
            Log.d("category", title3)
            cate3.setText(title3)

            var title4 = cateViewModel.getItemData(3)
            Log.d("category", title4)
            cate4.setText(title4)

            var title5 = cateViewModel.getItemData(4)
            Log.d("category", title5)
            cate5.setText(title5)

        })

        // 카테고리 별로 목록 분류
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame1, Fragment1())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame2, Fragment2())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame3, Fragment3())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame4, Fragment4())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame5, Fragment5())
            .commit()


    }
}