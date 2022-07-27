package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class signin : AppCompatActivity() {
    lateinit var okBtnsig: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        okBtnsig = findViewById(R.id.OK_signup)

        okBtnsig.setOnClickListener {
            val menuIntent = Intent(this, menu::class.java)
            startActivity(menuIntent)
        }
    }
}