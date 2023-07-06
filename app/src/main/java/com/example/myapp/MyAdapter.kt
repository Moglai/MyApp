package com.example.myapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_model.view.*

class MyAdapter(private val context: Context): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var Tasklist = emptyList<ModelTask>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_model, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.title.text = Tasklist[position].MyTask
        holder.itemView.description.text = Tasklist[position].MyDescription
        holder.itemView.setOnClickListener{
            Toast.makeText(context, "Haha it works!!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return Tasklist.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<ModelTask>) {
        Tasklist = list
        notifyDataSetChanged()
    }

}