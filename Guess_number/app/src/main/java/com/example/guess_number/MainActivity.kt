package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG:String = MainActivity::class.java.simpleName
    private lateinit var handler:Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Handler(Looper.getMainLooper())
        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val editText1 = findViewById<EditText>(R.id.editText1)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        var number_gap:Int
        editText1.text.clear()
        var min:Int=1
        var max:Int=100
        var secret:Int = Random().nextInt(100)+1

        button1.setOnClickListener{
            number_gap=editText1.text.toString().toInt()-secret

            when{
                number_gap < 0 -> {
                    textView1.setText(getString(R.string.guess_little))

                    min = editText1.text.toString().toInt()
                    textView1.text = "你猜得太小囉!"
                    //textView2.text=min.toString()+"-"+max.toString()
                }
                number_gap > 0 -> {
                    textView1.text = "你猜得太大囉!"
                    max = editText1.text.toString().toInt()
                    textView2.text=min.toString()+"-"+max.toString()
                }
                else -> {
                    textView1.text="你猜對了!!"
                    textView2.text="正確數字是"+secret.toString()
                    Toast.makeText(this,"6秒後重置遊戲",Toast.LENGTH_SHORT).show()
                    handler.postDelayed({
                        secret = Random().nextInt(100)+1
                        textView2.text=secret.toString()
                        textView1.text="重新開始猜數字"
                        textView2.text="1-100"
                        editText1.text.clear()
                        min=1
                        max=100
                    },6000)
                }

            }
            //Toast.makeText(this,editText1.text,Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            secret = Random().nextInt(100)+1
            textView2.text=secret.toString()
            textView1.text="重新開始猜數字"
            textView2.text="1-100"
            editText1.text.clear()
            min=1
            max=100
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}