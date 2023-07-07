package com.example.myapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.TaskModelBinding

interface  CardActionListener {
    fun onCardDelete(modelTask: ModelTask)
}

class NewAdapter(
    private val actionListener: CardActionListener
) : RecyclerView.Adapter<NewAdapter.TasksViewHolder>(), View.OnClickListener {


    var cards: List<ModelTask> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onClick(v: View) {
        val modelTask = v.tag as ModelTask
        actionListener.onCardDelete(modelTask)
    }

    override fun getItemCount(): Int = cards.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TaskModelBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)

        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val task = cards[position]
        with(holder.binding) {
            holder.itemView.tag = task
            title.text = task.MyTask
            description.text = task.MyDescription

        }
    }

    class TasksViewHolder(
        val binding: TaskModelBinding
    ) : RecyclerView.ViewHolder(binding.root)
}