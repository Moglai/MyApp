package com.example.myapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_model.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var Tasklist = emptyList<ModelTask>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_model, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.title.text = Tasklist[position].MyTask
        holder.itemView.description.text = Tasklist[position].MyDescription
    }

    override fun getItemCount(): Int {
        return Tasklist.size
    }

    fun setList(list: List<ModelTask>) {
        Tasklist = list
    }

}