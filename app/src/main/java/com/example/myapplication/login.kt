package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class login : AppCompatActivity() {
    lateinit var okBtnlog: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginn)

        okBtnlog = findViewById(R.id.OK_login)

        okBtnlog.setOnClickListener {
            val menuIntent = Intent(this, menu::class.java)
            startActivity(menuIntent)
        }
    }
}