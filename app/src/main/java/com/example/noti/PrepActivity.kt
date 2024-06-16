package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import android.widget.ProgressBar
import android.content.Intent
import android.widget.Button
import android.os.Bundle

class PrepActivity : AppCompatActivity() {
    private lateinit var loading: ProgressBar

    private fun setOnClickListenerForButton(buttonId: Int, level: String) {
        findViewById<Button>(buttonId).setOnClickListener {
            startActivity(Intent(this@PrepActivity , CalculationActivity::class.java).putExtra("Level", level))
            loading.isVisible = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prep)

        loading = findViewById(R.id.progress_loader)

        setOnClickListenerForButton(R.id.button7eme, "7eme")
        setOnClickListenerForButton(R.id.button8eme, "8eme")
        setOnClickListenerForButton(R.id.button9eme, "9eme")
    }

    override fun onResume() {
        super.onResume()
        loading.isVisible = false
    }
}