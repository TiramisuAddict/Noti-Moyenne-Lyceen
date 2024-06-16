package com.example.noti

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.Switch
import android.os.Bundle

class SettingsActivity : AppCompatActivity() {
    private lateinit var applyB: Button
    private lateinit var saveB: Button
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var dwSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        applyB = findViewById(R.id.applyButton)
        saveB = findViewById(R.id.saveB)
        dwSwitch = findViewById(R.id.DmSwitch)

        dwSwitch.isChecked = loadThemeData()

        applyB.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(
                if (dwSwitch.isChecked) AppCompatDelegate.MODE_NIGHT_NO
                else AppCompatDelegate.MODE_NIGHT_YES
            )
            saveThemeData(dwSwitch.isChecked)
        }

        saveB.setOnClickListener {
            startActivity(Intent(this@SettingsActivity, MainActivity::class.java))
        }
    }

    private fun loadThemeData(): Boolean {
        val sharedPrefrences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        return sharedPrefrences.getBoolean("LastThemeOption", true)
    }

    private fun saveThemeData(state: Boolean) {
        val sharedPrefrences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        with(sharedPrefrences.edit()) {
            putBoolean("LastThemeOption", state)
            apply()
        }
    }
}