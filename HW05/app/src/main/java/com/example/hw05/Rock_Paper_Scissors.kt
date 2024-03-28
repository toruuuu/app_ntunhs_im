package com.example.hw05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class Rock_Paper_Scissors : AppCompatActivity() {
    private lateinit var txtCom: TextView
    private lateinit var txtResult: TextView
    private lateinit var btnScissors: ImageButton
    private lateinit var btnRock: ImageButton
    private lateinit var btnPaper: ImageButton
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rock_paper_scissors)
        txtCom = findViewById<TextView>(R.id.txtCom)
        txtResult = findViewById<TextView>(R.id.txtResult)
        btnScissors = findViewById<ImageButton>(R.id.btnScissors)
        btnRock = findViewById<ImageButton>(R.id.btnRock)
        btnPaper = findViewById<ImageButton>(R.id.btnPaper)
        imageView = findViewById(R.id.comImageView)
        val backlobby = findViewById<Button>(R.id.game1tolobby)
        btnScissors.setOnClickListener{
            playGame(Choice.SCISSORS)
        }
        btnRock.setOnClickListener{
            playGame(Choice.ROCK)
        }
        btnPaper.setOnClickListener{
            playGame(Choice.PAPER)
        }
        backlobby.setOnClickListener{
            var mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
        }
    }
    enum class Choice{
        SCISSORS, ROCK, PAPER
    }
    fun playGame(playerChoice: Choice){
        val choices = Choice.values()
        val computerChoice = choices[Random.nextInt(choices.size)]

        when{
            playerChoice == computerChoice -> {
                txtCom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.draw)
                imageView.setImageResource(getComIamge(computerChoice))
            }
            (playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER) ||
                    (playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS)||
                    (playerChoice == Choice.PAPER && computerChoice == Choice.ROCK) -> {
                txtCom.setText(getChoiceString(computerChoice))
                imageView.setImageResource(getComIamge(computerChoice))
                txtResult.setText(R.string.win)
            }
            else -> {
                txtCom.setText(getChoiceString(computerChoice))
                imageView.setImageResource(getComIamge(computerChoice))
                txtResult.setText(R.string.lose)
            }
        }
    }
    fun getChoiceString(choice: Choice): Int{
        return when (choice){
            Choice.SCISSORS -> R.string.scissors
            Choice.ROCK -> R.string.rock
            Choice.PAPER -> R.string.paper
        }
    }
    fun getComIamge(choice: Choice): Int{
        return when (choice){
            Choice.SCISSORS -> R.drawable.scissor
            Choice.ROCK -> R.drawable.rock
            Choice.PAPER -> R.drawable.paper
        }
    }
}