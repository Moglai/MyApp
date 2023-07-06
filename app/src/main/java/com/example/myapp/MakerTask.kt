package com.example.myapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MakerTask : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_maker)

        val OKButton: Button = findViewById(R.id.ok_button)

        OKButton.setOnClickListener {
            val intent = Intent(this@MakerTask, ChangeTask::class.java)
            startActivity(intent)
        }
    }
}