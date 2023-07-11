package com.example.myapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.UUID

class TaskViewModel: ViewModel() {

    var taskModels = MutableLiveData<MutableList<TaskModel>>()

    init {
        taskModels.value = mutableListOf()
    }

    fun addTaskModel(newTask: TaskModel) {
        val list = taskModels.value
        list!!.add(newTask)
        taskModels.postValue(list)
    }

    fun updateTaskModel(id: UUID, name: String, desc: String) {
        val list = taskModels.value
        val task = list!!.find { it.id == id }!!
        task.name = name
        task.desc = desc
        taskModels.postValue(list)
    }

    fun setTaskModel(taskModel: TaskModel) {
        val list = taskModels.value
        val task = list!!.find { it.id == taskModel.id }!!
        taskModels.postValue(list)
    }
}