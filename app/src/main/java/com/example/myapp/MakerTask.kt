package com.example.myapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MakerTask : Activity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_maker)

        val OKButton: Button = findViewById(R.id.ok_button)
        val CreateTitle: EditText = findViewById(R.id.create_title)
        val CreateDescription: EditText = findViewById(R.id.create_description)

        OKButton.setOnClickListener {

            val intent = Intent(this@MakerTask, MainActivity::class.java)
            startActivity(intent)
        }
    }
}