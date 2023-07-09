package com.example.myapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.UUID

class TaskViewModel: ViewModel() {

    var taskModels = MutableLiveData<MutableList<TaskModel>>()

    init {
        taskModels.value = mutableListOf()
    }

    fun addTaskModel(nnewTask: TaskModel) {
        val list = taskModels.value
        list!!.add(nnewTask)
        taskModels.postValue(list)
    }

    fun updateTaskModel(id: UUID, name: String, desc: String) {
        val list = taskModels.value
        val taskk = list!!.find { it.id == id }!!
        taskk.name = name
        taskk.desc = desc
        taskModels.postValue(list)
    }

    fun setTaskModel(taskModel: TaskModel) {
        val list = taskModels.value
        val taskk = list!!.find { it.id == taskModel.id }!!
        taskModels.postValue(list)
    }
}