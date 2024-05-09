package com.example.app_record

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.example.app_record.databinding.ActivityAddRecordBinding
import com.example.app_record.databinding.ActivityMainBinding


class item_record2 : AppCompatActivity() {
    private lateinit var binding: ActivityAddRecordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSubmit.setOnClickListener{
            val sys = binding.etSys.text.toString().toIntOrNull() ?: 0
            val dia = binding.etDia.text.toString().toIntOrNull() ?: 0
            val hr = binding.etHr.text.toString().toIntOrNull() ?: 0
            val resultIntent = Intent()
            resultIntent.putExtra("sys", sys)
            resultIntent.putExtra("dia", dia)
            resultIntent.putExtra("hr", hr)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }


}