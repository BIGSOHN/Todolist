package com.cookandroid.todolist.category.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cookandroid.todolist.todo.db.TodoDao
import com.cookandroid.todolist.todo.db.TodoEntity

@Database(entities = [CategoryEntity::class, TodoEntity::class], version = 2)
abstract class CategoryDatabase : RoomDatabase() {

    abstract fun categoryDao() : CategoryDao
    abstract fun todoDao() : TodoDao

    companion object {
        @Volatile
        private var INSTANCE : CategoryDatabase? = null

        fun getDatabase(
            context : Context
        ) : CategoryDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CategoryDatabase::class.java,
                    "category_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}