package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: MyAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val DelAlls: ImageButton = findViewById(R.id.DelAll)
        val AddAlls: ImageButton = findViewById(R.id.AddAll)

        AddAlls.setOnClickListener {
            val intent = Intent(this@MainActivity, MakerTask::class.java)
            startActivity(intent)
        }
        DelAlls.setOnClickListener {
            val intent = Intent(this@MainActivity, ChangeTask::class.java)
            startActivity(intent)
        }
        initial()
    }

    private fun initial() {
        recyclerView = binding.RV
        adapter = MyAdapter(this)
        recyclerView.adapter = adapter
        adapter.setList(ThisCard())
    }

    fun ThisCard(): ArrayList<ModelTask> {
        val TaskList = ArrayList<ModelTask>()

        val Card = ModelTask("Work", "More")
        TaskList.add(Card)

        val Card2 = ModelTask("Work", "More")
        TaskList.add(Card2)

        val Card3 = ModelTask("Work", "More")
        TaskList.add(Card3)

        return TaskList
    }
}