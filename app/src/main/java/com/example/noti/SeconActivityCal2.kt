package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import android.widget.ProgressBar
import android.content.Intent
import android.widget.Button
import android.os.Bundle

class SeconActivityCal2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon_cal2)

        findViewById<Button>(R.id.bsc2).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal2 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.ble2).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal2 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bin2).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal2 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bec2).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal2 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

    }

    override fun onResume() {
        super.onResume()
        findViewById<ProgressBar>(R.id.progress_loader).isVisible = false
    }
}