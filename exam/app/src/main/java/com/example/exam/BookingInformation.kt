package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BookingInformation : AppCompatActivity() {
    private lateinit var outputPhone: TextView
    private lateinit var outputPerson: TextView
    private lateinit var outputNote: TextView
    private lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_information)
        outputPhone = findViewById(R.id.outputPhone)
        outputPerson = findViewById(R.id.outputPerson)
        outputNote = findViewById(R.id.outputNote)
        back = findViewById(R.id.back)

        // 從Intent獲取傳遞的資料
        val PhoneValue = intent.getStringExtra("PhoneValue")
        val AdultsValue = intent.getStringExtra("AdultsValue")
        val ChildrenValue = intent.getStringExtra("ChildrenValue")

        // 获取传递过来的字符串数组
        val checkBoxValues = intent.getStringArrayExtra("CheckBoxValues") ?: arrayOf()
        // 将数组转换为字符串，元素之间使用逗号和空格分隔
        val checkBoxValuesString = checkBoxValues.joinToString(separator = "、")


        // 使用TextView顯示資料
        outputPhone.text = "訂位電話:"+PhoneValue.toString()
        outputPerson.text = "訂位人數:"+AdultsValue.toString()+"大"+ ChildrenValue.toString()+"小"
        outputNote.text = "需要:"+checkBoxValuesString

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}