package com.example.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var counttext: TextView
    private lateinit var countbtn: Button
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counttext = findViewById(R.id.counttxt)
        countbtn = findViewById(R.id.countbtn)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        var count:LiveData<Int> = mainActivityViewModel.getInitialCounter()
        count.observe(this, Observer {
            counttext.text = it.toString()
        })



        countbtn.setOnClickListener {
            mainActivityViewModel.getCounter()
        }
    }
}