package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import android.widget.ImageButton
import android.content.Context
import android.widget.TextView
import android.content.Intent
import android.widget.Button
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private fun setTheme() {
        val isNightMode = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            .getBoolean("LastThemeOption", true)
        AppCompatDelegate.setDefaultNightMode(
            if (isNightMode) AppCompatDelegate.MODE_NIGHT_NO else AppCompatDelegate.MODE_NIGHT_YES
        )
    }

    private fun loadData(cardAverage: TextView) {
        val savedString = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            .getString("STRING_KEY", null)
        cardAverage.text = savedString ?: "0.00"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTheme()

        findViewById<Button>(R.id.preparatoryButton).setOnClickListener {
            startActivity(Intent(this, PrepActivity::class.java))
        }

        findViewById<Button>(R.id.secondaryButton).setOnClickListener {
            startActivity(Intent(this, SeconActivity::class.java))
        }

        findViewById<Button>(R.id.settingsButton).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        findViewById<ImageButton>(R.id.creditsButton).setOnClickListener {
            startActivity(Intent(this, CreditsActivity::class.java))
        }

        findViewById<CardView>(R.id.historyCard).setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        val cardAverage = findViewById<TextView>(R.id.lastAverage)
        loadData(cardAverage)
    }
}