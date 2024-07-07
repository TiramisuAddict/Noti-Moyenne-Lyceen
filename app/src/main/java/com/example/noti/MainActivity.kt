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
import androidx.core.app.ActivityOptionsCompat

class MainActivity : AppCompatActivity() {
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

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
        val animations = Animations()

        findViewById<Button>(R.id.preparatoryButton).setOnClickListener {
            val intent = Intent(this, PrepActivity::class.java)
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())
        }

        findViewById<Button>(R.id.secondaryButton).setOnClickListener {
            val intent = Intent(this, SeconActivity::class.java)
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())
        }

        findViewById<Button>(R.id.settingsButton).setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())
        }

        findViewById<ImageButton>(R.id.creditsButton).setOnClickListener {
            val intent = Intent(this, CreditsActivity::class.java)
            val options = animations.swipeEffect(this, "swipeLeft")
            startActivity(intent , options.toBundle())
        }

        findViewById<CardView>(R.id.historyCard).setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            val options = animations.swipeEffect(this, "swipeLeft")
            startActivity(intent , options.toBundle())
        }

        val cardAverage = findViewById<TextView>(R.id.lastAverage)
        loadData(cardAverage)
    }
}