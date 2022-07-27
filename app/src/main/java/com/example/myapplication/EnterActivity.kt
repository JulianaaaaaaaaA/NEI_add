package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EnterActivity : AppCompatActivity() {
    lateinit var signinBtn: Button
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (false) {
            val menuIntent = Intent(this, menu::class.java)
            startActivity(menuIntent)
        }
        setContentView(R.layout.activity_enter)

        signinBtn = findViewById(R.id.signinID)
        loginBtn = findViewById(R.id.loginID)

        signinBtn.setOnClickListener {
            val signinIntent = Intent(this, signin::class.java)
            startActivity(signinIntent)
        }

        loginBtn.setOnClickListener {
            val loginIntent = Intent(this, login::class.java)
            startActivity(loginIntent)
        }

    }
}