package com.cookandroid.todolist.category.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.todolist.R
import com.cookandroid.todolist.category.db.CategoryAdapter
import com.cookandroid.todolist.category.db.CategoryDatabase
import com.cookandroid.todolist.category.db.CategoryViewModel
import com.cookandroid.todolist.databinding.ActivityContentCategoryBinding

class Content_Category : AppCompatActivity() {

    private lateinit var binding : ActivityContentCategoryBinding

    lateinit var viewmodel : CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_content_category)

        var intent = Intent(this, Modi_Romove::class.java)

        //뷰모델
        viewmodel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        viewmodel.getData()

        val cateDB = CategoryDatabase.getDatabase(this)

        val rvView = binding.rv

        //어뎁터 연결, 아이템 클릭 이벤트 처리
        viewmodel.categoryList.observe(this, Observer {
            val categoryAdapter = CategoryAdapter(it)
            rvView.adapter = categoryAdapter
            rvView.layoutManager = LinearLayoutManager(this)

            categoryAdapter.itemClick = object : CategoryAdapter.CategoryItemClick {
                override fun onClick(view: View, position: Int) {
                    intent.putExtra("position", position)
                    startActivity(intent)

                    Log.d("contentcategory", position.toString())
                }
            }
        })

        binding.back1.setOnClickListener {

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        // 카테고리 5개까지 추가 가능
        viewmodel.getTitleData()
        binding.categoryAdd.setOnClickListener {
            var title = viewmodel.getItemData(4)
            if(viewmodel.getItemData(4) == "") {
                var intent = Intent(this, Category_Input::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "카테고리는 5개까지 추가 가능", Toast.LENGTH_SHORT).show()
            }
        }

    }
}