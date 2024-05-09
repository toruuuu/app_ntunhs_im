package com.example.app_record

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Adapter
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_record.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: RecordAdapter
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarMain.inflateMenu(R.menu.menu)
        mAdapter = RecordAdapter(this, Bprecords(emptyList()))
        binding.recordRecycler.adapter=mAdapter
        binding.recordRecycler.layoutManager = LinearLayoutManager(this)
        val records = Bprecords(mutableListOf(
                Bprecord("2024-05-09 10:00",120,80,72),
                Bprecord("2024-05-08 12:05",115,70,80),
                Bprecord("2024-05-07 11:20",112,68,75)
            ))
        mAdapter.updateData(records)
        binding.toolbarMain.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.menu_add->{
                    Log.e(TAG, "Menu_add")
                    val intent = Intent(this, item_record2::class.java)
                    startActivity(intent)
                }
            }
            true
        }


    }
    companion object {
        const val REQUEST_CODE_ADD_RECORD = 1
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e(TAG, "item_add1")
        if(requestCode == REQUEST_CODE_ADD_RECORD && resultCode == Activity.RESULT_OK){
            Log.e(TAG, "item_add")
            val sys = data?.getIntExtra("sys", 0) ?: 0// 如果沒有數據，預設值為0
            val dia = data?.getIntExtra("dia", 0) ?: 0
            val hr = data?.getIntExtra("hr", 0) ?: 0
            val newRecord = Bprecord(getCurrentDateTime(), 8, 9, 10)

            mAdapter.addRecord(newRecord)
        }

    }
    fun getCurrentDateTime(): String{
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return current.format(formatter)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId){
            R.id.menu_add -> {
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}