package com.example.user_profilo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spnCity = findViewById<Spinner>(R.id.spn_City)
        val adapter = ArrayAdapter.createFromResource(this,R.array.city,
            android.R.layout.simple_spinner_dropdown_item)

        spnCity.adapter = adapter

        spnCity.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long){
                val city = resources.getStringArray(R.array.city)
                if (pos>0)
                    Toast.makeText(this@MainActivity,"你選的是"+city[pos],
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                TODO("Not yet implemented")
            }
        }
    }
}