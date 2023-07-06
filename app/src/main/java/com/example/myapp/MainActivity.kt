package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
    }
}