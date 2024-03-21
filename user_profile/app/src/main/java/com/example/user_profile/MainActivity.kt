package com.example.user_profile

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.Calendar

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val acc = findViewById<EditText>(R.id.acc)
            val pwd = findViewById<EditText>(R.id.pwd)
            val name = findViewById<EditText>(R.id.name)
            val applyDate = findViewById<EditText>(R.id.Birthday)
            val radGrp_gender = findViewById<RadioGroup>(R.id.group_gender)
            val radBtn_male = findViewById<RadioButton>(R.id.male)
            val radBtn_female = findViewById<RadioButton>(R.id.female)
            val MRT = findViewById<CheckBox>(R.id.MRT)
            val bike = findViewById<CheckBox>(R.id.bike)
            val car = findViewById<CheckBox>(R.id.car)
            val submit = findViewById<Button>(R.id.button)

        radGrp_gender.setOnCheckedChangeListener{ _, checkedId ->
            var gender = when (checkedId)
            {
                R.id.female -> radBtn_female.text.toString()
                R.id.male -> radBtn_male.text.toString()
                else -> "I don't know"
            }
            Toast.makeText(this,gender,Toast.LENGTH_SHORT).show()
        }

        //日期
        applyDate.setOnClickListener{
            val calendar=Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this,
                { _, year, month, day ->
                    run{
                            var format = "${setDateFormat(year, month, day)}"
                            applyDate.setText(format)
                        }
                }, year, month, day).show()
        }
        submit.setOnClickListener{

            val hobby = StringBuilder("\n")

            // 获取选中的RadioButton的ID
            val selectedRadioButtonId = radGrp_gender.checkedRadioButtonId
            // 根据ID找到RadioButton
            val radioButton = findViewById<RadioButton>(selectedRadioButtonId)


            if (MRT.isChecked) hobby.append("公車\n")
            if (bike.isChecked) hobby.append("腳踏車\n")
            if (car.isChecked) hobby.append("四輪車\n")

            AlertDialog.Builder(this).setTitle("送出訊息").setMessage(
                    "ID: "+acc.text.toString()+"\n" +
                    "PWD: "+pwd.text.toString()+"\n" +
                    "Name: "+name.text.toString() + "\n" +
                    "Birthdate: "+applyDate.text.toString() + "\n" +
                    "Gender: ${radioButton.text}" + "\n" +
                    "Vehicle: "+hobby.toString()).create().show()
        }
    }
    private fun setDateFormat(year: Int,month: Int, day: Int): String
    {
        return "$year-${month + 1}-$day"
    }
}

