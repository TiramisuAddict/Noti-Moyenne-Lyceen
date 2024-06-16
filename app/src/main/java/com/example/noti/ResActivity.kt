package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.os.Bundle

class ResActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var menuButton: Button

    private fun saveData() {
        val sharedPrefrences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPrefrences.edit()

        editor.apply {
            putString("STRING_KEY", resultTextView.text.toString())
        }.apply()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res)

        resultTextView = findViewById(R.id.resultText)
        menuButton = findViewById(R.id.menuButton)

        resultTextView.text = intent.getStringExtra("Moy")

        menuButton.setOnClickListener {
            finish()
            startActivity(Intent(this, MainActivity::class.java))
            saveData()
        }
    }
}