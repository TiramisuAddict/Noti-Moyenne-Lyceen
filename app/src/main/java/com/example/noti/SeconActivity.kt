package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import android.widget.ProgressBar
import android.content.Intent
import android.widget.Button
import android.os.Bundle

class SeconActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon)

        findViewById<ProgressBar>(R.id.progress_loader).isVisible = false

        findViewById<Button>(R.id.button1ere).setOnClickListener {
            startActivity(Intent(this@SeconActivity , CalculationActivity::class.java).putExtra("Level", "1ere"))
        }

        findViewById<Button>(R.id.button2eme).setOnClickListener {
            startActivity(Intent(this@SeconActivity , SeconActivityCal2::class.java))
        }

        findViewById<Button>(R.id.button3eme).setOnClickListener {
            startActivity(Intent(this@SeconActivity , SeconActivityCal3::class.java))
        }

        findViewById<Button>(R.id.button4eme).setOnClickListener {
            startActivity(Intent(this@SeconActivity , SeconActivityCal4::class.java))
        }

    }

}