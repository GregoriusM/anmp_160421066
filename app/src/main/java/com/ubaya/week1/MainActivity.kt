package com.ubaya.week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        //TODO: ini cuma percobaan week 1
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}