package com.cookandroid.todolist.todo.mainfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.todolist.R
import com.cookandroid.todolist.category.activity.MainActivity
import com.cookandroid.todolist.category.db.CategoryDatabase
import com.cookandroid.todolist.databinding.Fragment1Binding
import com.cookandroid.todolist.databinding.Fragment5Binding
import com.cookandroid.todolist.todo.db.TodoAdapter
import com.cookandroid.todolist.todo.db.TodoViewModel
import com.cookandroid.todolist.todo.mainfragment.modifyremove.Modi_Remove_Todo5

class Fragment5 : Fragment() {
    private lateinit var viewBinding : Fragment5Binding

    lateinit var cate5ViewModel : TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = Fragment5Binding.inflate(layoutInflater)
        val view = viewBinding.root

        cate5ViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        cate5ViewModel.getCate5Data()

        val context = container!!.context

        val db = CategoryDatabase.getDatabase(context)

        val rv = viewBinding.rv5

        var intent = Intent(context, Modi_Remove_Todo5::class.java)

        //어뎁터 연결 + 아이템 클릭 이벤트
        cate5ViewModel.todoList.observe(viewLifecycleOwner, Observer {
            val todoAdapter = TodoAdapter(it)
            rv.adapter = todoAdapter
            rv.layoutManager = LinearLayoutManager(context)

            todoAdapter.itemClick = object : TodoAdapter.TodoItemClick {
                override fun onClick(view: View, position: Int) {
                    intent.putExtra("todoPosition5", position)
                    startActivity(intent)
                    Log.d("contentcategory", position.toString())
                }
            }
        })

        return view
    }
}