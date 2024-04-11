package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var editPhone: EditText
    private lateinit var numberAdults: Spinner
    private lateinit var numberChildren: Spinner
    private lateinit var note1: CheckBox
    private lateinit var note2: CheckBox
    private lateinit var submit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editPhone = findViewById(R.id.editPhone)
        numberAdults = findViewById(R.id.numberAdults)
        numberChildren = findViewById(R.id.numberChildren)
        note1 = findViewById(R.id.note1)
        note2 = findViewById(R.id.note2)
        submit = findViewById(R.id.submit)
        val number1 = arrayListOf("1","2","3","4","5","6","7","8","9","10")
        val number2 = arrayListOf("1","2","3","4","5","6","7","8","9","10")
        val adapter1 = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,number1)
        val adapter2 = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,number2)
        numberAdults.adapter = adapter1
        numberChildren.adapter = adapter2

        submit.setOnClickListener {
            val intent = Intent(this, BookingInformation::class.java)

            // 獲取EditText的文字
            intent.putExtra("PhoneValue", editPhone.text.toString())

            // 獲取Spinner選擇的項目文字
            intent.putExtra("AdultsValue", numberAdults.selectedItem.toString())
            intent.putExtra("ChildrenValue", numberChildren.selectedItem.toString())
            // 獲取CheckBox勾選的項目文字
            val checkBoxValues = mutableListOf<String>()
            if (note1.isChecked) checkBoxValues.add(getString(R.string.note1))
            if (note2.isChecked) checkBoxValues.add(getString(R.string.note2))

            // 使用joinToString連接字符串，中間用逗號和空格分隔
            //val checkBoxValuesString = checkBoxValues.joinToString(separator = "、")

            Log.e("LogInfo", "電話號碼: ${editPhone.text}")
            Log.e("LogInfo", "兒童需求: ${checkBoxValues.joinToString(", ")}")
            val selectedItemText1 = numberAdults.selectedItem.toString()
            val selectedItemText2 = numberChildren.selectedItem.toString()
            Log.e("LogInfo", "大人人數: $selectedItemText1")
            Log.e("LogInfo", "小孩人數: $selectedItemText2")

            intent.putExtra("CheckBoxValues", checkBoxValues.toTypedArray())

            startActivity(intent)
        }
    }
}