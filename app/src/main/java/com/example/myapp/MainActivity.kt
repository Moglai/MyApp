package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity(), TaskModelClickListener {


    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.AddAll.setOnClickListener {
            NewTask(null).show(supportFragmentManager, "NewTaskTag")
        }
        setRV()
    }

    private fun setRV() {
        val MainActivity = this
        taskViewModel.taskModels.observe(this) {
            binding.MyRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = MegaAdapter(it, MainActivity)
            }
        }
    }

    override fun changeTaskModel(taskModel: TaskModel) {
        NewTask(taskModel).show(supportFragmentManager, "newTaskTag")
    }

    override fun OKTaskModel(taskModel: TaskModel) {
        taskViewModel.setTaskModel(taskModel)
    }
}