package com.example.myapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class ChangeTask : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_change)

        val UpdateButton: Button = findViewById(R.id.update_button)
        val DeleteButton: Button = findViewById(R.id.delete_button)


        UpdateButton.setOnClickListener {
            val intent = Intent(this@ChangeTask, MainActivity::class.java)
            startActivity(intent)
        }
        DeleteButton.setOnClickListener {
            val intent = Intent(this@ChangeTask, MakerTask::class.java)
            startActivity(intent)
        }
    }
}