package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import android.widget.ProgressBar
import android.content.Intent
import android.widget.Button
import android.os.Bundle

class SeconActivityCal4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon_cal4)

        findViewById<Button>(R.id.bsc4).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bma4).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.ble4).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bin4).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bte4).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bec4).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal4 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

    }

    override fun onResume() {
        super.onResume()
        findViewById<ProgressBar>(R.id.progress_loader).isVisible = false
    }

}