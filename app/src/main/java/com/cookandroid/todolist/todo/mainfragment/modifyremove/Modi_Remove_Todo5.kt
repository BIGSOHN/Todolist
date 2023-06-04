package com.cookandroid.todolist.todo.mainfragment.modifyremove

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cookandroid.todolist.R
import com.cookandroid.todolist.category.activity.MainActivity
import com.cookandroid.todolist.category.db.CategoryDatabase
import com.cookandroid.todolist.databinding.ActivityModiRemoveTodo2Binding
import com.cookandroid.todolist.databinding.ActivityModiRemoveTodo5Binding
import com.cookandroid.todolist.todo.db.TodoAdapter
import com.cookandroid.todolist.todo.db.TodoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Modi_Remove_Todo5 : AppCompatActivity() {

    private lateinit var binding : ActivityModiRemoveTodo5Binding

    lateinit var todoViewModel : TodoViewModel

    var todoDB = CategoryDatabase.getDatabase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_modi_remove_todo5)

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        todoViewModel.getCate5Data()

        val position = intent.getIntExtra("todoPosition5", 0)

        todoViewModel.todoList.observe(this, Observer {
            val todoAdapter = TodoAdapter(it)

            val todoItemTitle = todoAdapter.getTodoTitle(position)
            val todoItemDate = todoAdapter.getTodoDate(position)

            binding.todoTitle.setText(todoItemTitle)
            binding.todoDate.setText(todoItemDate)

            val todoItemPriority = todoAdapter.getTodoPriorty(position)

            when(todoItemPriority) {
                "상" -> binding.radio1.isChecked = true
                "중" -> binding.radio2.isChecked = true
                "하" -> binding.radio3.isChecked = true
            }

            val todoItemCategory = todoAdapter.getTodoCategory(position)

        })

        binding.update.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                val result = todoDB.todoDao().getAllData()
                val todoEntity = result[position]
                todoEntity.todoTitle = binding.todoTitle.text.toString()

                todoDB.todoDao().update(todoEntity)
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.delete.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val result = todoDB.todoDao().getAllData()
                val todoEntity = result[position]

                todoDB.todoDao().delete(todoEntity)
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}