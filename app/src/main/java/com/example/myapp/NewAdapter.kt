package com.example.myapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.TaskModelBinding

class NewAdapter : RecyclerView.Adapter<NewAdapter.TasksViewHolder>() {

    var cards: List<ModelTask> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = cards.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TaskModelBinding.inflate(inflater, parent, false)
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val task = cards[position]
        with(holder.binding) {
            title.text = task.MyTask
            description.text = task.MyDescription

        }
    }

    class TasksViewHolder(
        val binding: TaskModelBinding
    ) : RecyclerView.ViewHolder(binding.root)
}