package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.os.Bundle

class CreditsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits)

        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener{
            startActivity(Intent(this@CreditsActivity , MainActivity::class.java))
        }
    }
}