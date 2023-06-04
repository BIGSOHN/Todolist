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
import com.cookandroid.todolist.category.db.CategoryDatabase
import com.cookandroid.todolist.category.db.CategoryViewModel
import com.cookandroid.todolist.databinding.Fragment2Binding
import com.cookandroid.todolist.todo.mainfragment.modifyremove.Modi_Remove_Todo2
import com.cookandroid.todolist.todo.db.TodoAdapter
import com.cookandroid.todolist.todo.db.TodoViewModel

class Fragment2 : Fragment() {

    private lateinit var viewBinding : Fragment2Binding

    lateinit var todo2ViewModel : TodoViewModel

    lateinit var cate2ViewModel : CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = Fragment2Binding.inflate(layoutInflater)
        val view = viewBinding.root

        cate2ViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        todo2ViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        cate2ViewModel.getTitleData()
        cate2ViewModel.titleList.observe(viewLifecycleOwner, Observer {

            todo2ViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
            todo2ViewModel.getCate2Data()

        })

        val context = container!!.context

        val db = CategoryDatabase.getDatabase(context)

        val rv = viewBinding.rv2

        var intent = Intent(context, Modi_Remove_Todo2::class.java)

        // 어뎁터 연결 + 아이템 클릭 이벤트
        todo2ViewModel.todoList.observe(viewLifecycleOwner, Observer {
            val todoAdapter = TodoAdapter(it)
            rv.adapter = todoAdapter
            rv.layoutManager = LinearLayoutManager(context)

            todoAdapter.itemClick = object : TodoAdapter.TodoItemClick {
                override fun onClick(view: View, position: Int) {
                    intent.putExtra("todoPosition2", position)
                    startActivity(intent)
                    Log.d("contentcategory", position.toString())
                }
            }
        })

        return view
    }

}