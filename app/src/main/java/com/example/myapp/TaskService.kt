package com.example.myapp

import com.github.javafaker.Faker

class TaskService {

    var cards = mutableListOf<ModelTask>()

    init {
        val faker = Faker.instance()
        val generetedTasks = (1..10).map { ModelTask(
            id = it.toLong(),
            MyTask = faker.name().name(),
            MyDescription = faker.name().name()
        ) }
    }

    fun getTasks(): List<ModelTask> {
        return cards
    }

    fun deleteTask (modelTask: ModelTask) {
        val indexToDelete = cards.indexOfFirst { it.id == modelTask.id }
        if (indexToDelete != -1) {
            cards.removeAt(indexToDelete)
        }
    }


}