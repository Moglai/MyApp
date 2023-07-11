package com.example.myapp

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.TaskModelkaBinding

class TaskModelViewHolder (
    private val context: Context,
    private val binding: TaskModelkaBinding,
    private val clickListener: TaskModelClickListener
): RecyclerView.ViewHolder(binding.root)
{
    fun bindTaskModel (taskModel: TaskModel) {
        binding.title.text = taskModel.name
        binding.description.text = taskModel.desc
        binding.mylayout.setOnClickListener {
            clickListener.changeTaskModel(taskModel)
        }
    }
}