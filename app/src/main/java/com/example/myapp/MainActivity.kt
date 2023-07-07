package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NewAdapter

    private val taskService: TaskService
        get() = (applicationContext as App).taskService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = NewAdapter(object : CardActionListener {
            override fun onCardDelete(modelTask: ModelTask) {
                taskService.deleteTask(modelTask)
            }
        })

        val layoutManager = LinearLayoutManager(this)
        binding.RV.layoutManager = layoutManager
        binding.RV.adapter = adapter

        taskService.addListener(cardsListener)

        val AddAlls: ImageButton = findViewById(R.id.AddAll)

        AddAlls.setOnClickListener {
            val intent = Intent(this@MainActivity, MakerTask::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        taskService.removeListener(cardsListener)
    }

    private val cardsListener: CardsListener = {
        adapter.cards = it
    }
}