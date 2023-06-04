package com.cookandroid.todolist.category.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.todolist.R

class CategoryAdapter(private val dataSet : List<CategoryEntity>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    interface CategoryItemClick {
        fun onClick(view : View, position : Int)
    }

    fun getCateItem(position : Int) : String{
        var cateItemName = dataSet[position].cateName
        return cateItemName
    }

    var itemClick : CategoryItemClick? = null

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textView : TextView = view.findViewById(R.id.rv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_rv_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(itemClick != null) {
            holder?.itemView?.setOnClickListener { v ->
                itemClick?.onClick(v,position)
            }
        }
        holder.textView.text = dataSet[position].cateName
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}