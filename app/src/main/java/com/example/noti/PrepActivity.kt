package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import android.widget.ProgressBar
import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat

class PrepActivity : AppCompatActivity() {
    private lateinit var loading: ProgressBar

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prep)

        loading = findViewById(R.id.progress_loader)

        val animations = Animations()

        findViewById<Button>(R.id.button7eme).setOnClickListener {
            val intent = Intent(this, CalculationActivity::class.java).putExtra("Level", "7eme")
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())

            loading.isVisible = true
        }

        findViewById<Button>(R.id.button8eme).setOnClickListener {
            val intent = Intent(this, CalculationActivity::class.java).putExtra("Level", "8eme")
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())

            loading.isVisible = true
        }

        findViewById<Button>(R.id.button9eme).setOnClickListener {
            val intent = Intent(this, CalculationActivity::class.java).putExtra("Level", "9eme")
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())

            loading.isVisible = true
        }

    }

    override fun onResume() {
        super.onResume()
        loading.isVisible = false
    }
}