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
import com.cookandroid.todolist.databinding.Fragment1Binding
import com.cookandroid.todolist.todo.mainfragment.modifyremove.Modi_Remove_Todo1
import com.cookandroid.todolist.todo.db.TodoAdapter
import com.cookandroid.todolist.todo.db.TodoViewModel

class Fragment1 : Fragment() {

    private lateinit var viewBinding : Fragment1Binding

    lateinit var todo1ViewModel : TodoViewModel

    lateinit var cate1ViewModel : CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = Fragment1Binding.inflate(layoutInflater)
        val view = viewBinding.root

        cate1ViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        todo1ViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        cate1ViewModel.getTitleData()
        cate1ViewModel.titleList.observe(viewLifecycleOwner, Observer {

            todo1ViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
            todo1ViewModel.getCate1Data()

        })

        val context = container!!.context

        val db = CategoryDatabase.getDatabase(context)

        val rv = viewBinding.rv1

        var intent = Intent(context, Modi_Remove_Todo1::class.java)

        // 어뎁터 연결 + 아이템 클릭 이벤트
        todo1ViewModel.todoList.observe(viewLifecycleOwner, Observer {
            val todoAdapter = TodoAdapter(it)
            rv.adapter = todoAdapter
            rv.layoutManager = LinearLayoutManager(context)

            todoAdapter.itemClick = object : TodoAdapter.TodoItemClick {
                override fun onClick(view: View, position: Int) {
                    intent.putExtra("todoPosition", position)
                    startActivity(intent)
                    Log.d("contentcategory", position.toString())
                }
            }
        })

        return view
    }

}