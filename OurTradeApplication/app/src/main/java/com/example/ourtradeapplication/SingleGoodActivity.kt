package com.example.ourtradeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SingleGoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_good)
        findViewById<ImageView>(R.id.back).setOnClickListener{
            onBackPressed()
        }
    }
}