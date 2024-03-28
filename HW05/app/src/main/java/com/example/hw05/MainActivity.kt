package com.example.hw05

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeActivity = findViewById<Button>(R.id.btnChangeActivity)
        val btnOpenBrowser = findViewById<Button>(R.id.btnOpenBrowser)
        val RPSActivity = findViewById<Button>(R.id.RPSActivity)
        val GNActivity = findViewById<Button>(R.id.GNActivity)
        btnChangeActivity.setOnClickListener{
            var secondIntent = Intent(this,SecondActivity::class.java)
            startActivity(secondIntent)
        }
        btnOpenBrowser.setOnClickListener{
            var secondIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(secondIntent)
        }

        GNActivity.setOnClickListener{
            var game1 = Intent(this,guess_number::class.java)
            startActivity(game1)
        }

        RPSActivity.setOnClickListener{
            var game2 = Intent(this,Rock_Paper_Scissors::class.java)
            startActivity(game2)
        }
    }
}