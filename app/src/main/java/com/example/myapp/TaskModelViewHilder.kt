package com.example.myapp

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.TaskModelBinding

class TaskModelViewHolder (
    private val context: Context,
    private val binding: TaskModelBinding
): RecyclerView.ViewHolder(binding.root)
{
    fun bindTaskModel (taskModel: TaskModel) {
        binding.title.text = taskModel.name
        binding.description.text = taskModel.desc
    }
}