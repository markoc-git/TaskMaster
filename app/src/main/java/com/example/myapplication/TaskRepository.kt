package com.example.myapplication

import android.content.Context
import android.widget.Toast

class TaskRepository(private val taskDao: TaskDao, private val context: Context) {

    suspend fun insertTask(task: Task): Boolean {
        return try {
            taskDao.insertTask(task)
            Toast.makeText(context, "Succcessful inserting task :) ", Toast.LENGTH_SHORT).show()
            true
        } catch (e: Exception) {
            Toast.makeText(context, "Error inserting task", Toast.LENGTH_SHORT).show()
            false
        }
    }
}
