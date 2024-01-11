package com.example.myapplication

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    private val _insertTaskResult = MutableLiveData<Boolean>()
    val insertTaskResult: LiveData<Boolean> get() = _insertTaskResult

    fun insertTask(task: Task) {
        GlobalScope.launch {
            _insertTaskResult.postValue(repository.insertTask(task))
        }
    }
}
