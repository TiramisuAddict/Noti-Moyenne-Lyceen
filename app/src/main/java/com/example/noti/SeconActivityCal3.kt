package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import android.widget.ProgressBar
import android.content.Intent
import android.widget.Button
import android.os.Bundle

class SeconActivityCal3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon_cal3)

        findViewById<Button>(R.id.bsc3).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bma3).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.ble3).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bin3).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bte3).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bec3).setOnClickListener {
            startActivity(Intent(this@SeconActivityCal3 , CalculationActivity::class.java).putExtra("Level", "1ere"))
            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

    }

    override fun onResume() {
        super.onResume()
        findViewById<ProgressBar>(R.id.progress_loader).isVisible = false
    }

}