package com.example.myapp

import com.github.javafaker.Faker

typealias CardsListener = (cards: List<ModelTask>) -> Unit

class TaskService {

    var cards = mutableListOf<ModelTask>()
    val listeners = mutableSetOf<CardsListener>()

    init {
        val faker = Faker.instance()
        cards = (1..10).map { ModelTask(
            id = it.toLong(),
            MyTask = faker.name().name(),
            MyDescription = faker.name().name()
        ) }.toMutableList()
    }

    fun getTasks(): List<ModelTask> {
        return cards
    }

    fun deleteTask (modelTask: ModelTask) {
        val indexToDelete = cards.indexOfFirst { it.id == modelTask.id }
        if (indexToDelete != -1) {
            cards.removeAt(indexToDelete)
            notifyChanges()
        }
    }
    fun addListener(listener: CardsListener) {
        listeners.add (listener)
        listener.invoke(cards)
    }
    fun removeListener(listener: CardsListener) {
        listeners.remove (listener)
    }

    private fun notifyChanges() {
        listeners.forEach { it.invoke(cards)}
    }

}