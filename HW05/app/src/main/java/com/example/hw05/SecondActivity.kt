package com.example.hw05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnBacktoFirst = findViewById<Button>(R.id.btnBacktoFirst)

        btnBacktoFirst.setOnClickListener{
            var mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
        }
    }
}