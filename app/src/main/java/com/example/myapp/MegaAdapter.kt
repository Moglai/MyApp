package com.example.myapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.TaskModelBinding

class MegaAdapter(
    private val taskModels: List<TaskModel>
): RecyclerView.Adapter<TaskModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskModelViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = TaskModelBinding.inflate(from, parent, false)
        return TaskModelViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: TaskModelViewHolder, position: Int) {
        holder.bindTaskModel(taskModels[position])
    }

    override fun getItemCount(): Int = taskModels.size
}