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
import com.cookandroid.todolist.databinding.Fragment2Binding
import com.cookandroid.todolist.databinding.Fragment3Binding
import com.cookandroid.todolist.todo.db.TodoAdapter
import com.cookandroid.todolist.todo.db.TodoViewModel
import com.cookandroid.todolist.todo.mainfragment.modifyremove.Modi_Remove_Todo3

class Fragment3 : Fragment() {

    private lateinit var viewBinding : Fragment3Binding
    private lateinit var cate3ViewModel : TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = Fragment3Binding.inflate(layoutInflater)
        val view = viewBinding.root

        cate3ViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        cate3ViewModel.getCate3Data()

        val context = container!!.context

        val db = CategoryDatabase.getDatabase(context)

        val rv = viewBinding.rv3

        var intent = Intent(context, Modi_Remove_Todo3::class.java)

        //어뎁터 연결 + 아이템 클릭 이벤트
        cate3ViewModel.todoList.observe(viewLifecycleOwner, Observer {
            val todoAdapter = TodoAdapter(it)
            rv.adapter = todoAdapter
            rv.layoutManager = LinearLayoutManager(context)

            todoAdapter.itemClick = object : TodoAdapter.TodoItemClick {
                override fun onClick(view: View, position: Int) {
                    intent.putExtra("todoPosition3", position)
                    startActivity(intent)
                    Log.d("contentcategory", position.toString())
                }
            }
        })

        return view
    }
}