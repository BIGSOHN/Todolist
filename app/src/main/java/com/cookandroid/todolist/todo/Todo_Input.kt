package com.cookandroid.todolist.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cookandroid.todolist.R
import com.cookandroid.todolist.category.activity.Content_Category
import com.cookandroid.todolist.category.activity.MainActivity
import com.cookandroid.todolist.category.db.CategoryDatabase
import com.cookandroid.todolist.category.db.CategoryViewModel
import com.cookandroid.todolist.todo.db.TodoViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class Todo_Input : AppCompatActivity() {

    private lateinit var cateViewModel : CategoryViewModel
    private lateinit var todoViewModel : TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_input)

        cateViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        val cateDB = CategoryDatabase.getDatabase(this)
        lateinit var category : String
        var categoryPosition : Int = 0

        cateViewModel.getTitleData()
        cateViewModel.titleList.observe(this, Observer {
            var title1 = cateViewModel.getItemData(0)
            var title2 = cateViewModel.getItemData(1)
            var title3 = cateViewModel.getItemData(2)
            var title4 = cateViewModel.getItemData(3)
            var title5 = cateViewModel.getItemData(4)
            Log.d("abc", title1)
            var categorySpinnerList = arrayListOf(title1, title2, title3, title4, title5)

            var adapter =
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categorySpinnerList)

            val spinner = findViewById<Spinner>(R.id.spinner)

            spinner.adapter = adapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    category = categorySpinnerList.get(position)
                    categoryPosition = position+1
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(baseContext, "카테고리를 선택해주세요.", Toast.LENGTH_LONG).show()
                }
            }
        })

        var date = findViewById<EditText>(R.id.todoDate)
        var title = findViewById<EditText>(R.id.todoTitle)
        val cancel = findViewById<TextView>(R.id.cancel)
        val complete = findViewById<TextView>(R.id.complete)

        // 현재 날짜 설정
        var calendar = Calendar.getInstance()
        var today = Date()
        calendar.time = today

        val dateFormat = SimpleDateFormat("yy-MM-dd", Locale("ko", "KR")) // 날짜 포맷

        date.setText(dateFormat.format(calendar.time).toString())

        // 우선순위 선택
        val radiogroup = findViewById<RadioGroup>(R.id.radioGroup)
        var priority : String = ""
        radiogroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radio1 -> {
                    priority = "상"
                }

                R.id.radio2 -> {
                    priority = "중"
                }

                R.id.radio3 -> {
                    priority = "하"
                }
            }
        }

        // 완료 버튼 클릭 이벤트
        complete.setOnClickListener {
            todoViewModel.insertData(title.text.toString(), date.text.toString(), false, categoryPosition, priority)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 취소 버튼 클릭 이벤트
        cancel.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}