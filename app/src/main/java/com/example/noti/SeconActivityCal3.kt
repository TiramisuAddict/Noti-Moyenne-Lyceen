package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import android.widget.ProgressBar
import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat

class SeconActivityCal3 : AppCompatActivity() {
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon_cal3)

        val animations = Animations()

        findViewById<Button>(R.id.bsc3).setOnClickListener {
            val intent = Intent(this@SeconActivityCal3, CalculationActivity::class.java).putExtra("Level", "1ere")
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())

            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bma3).setOnClickListener {
            val intent = Intent(this@SeconActivityCal3, CalculationActivity::class.java).putExtra("Level", "1ere")
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())

            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.ble3).setOnClickListener {
            val intent = Intent(this@SeconActivityCal3, CalculationActivity::class.java).putExtra("Level", "1ere")
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())

            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bin3).setOnClickListener {
            val intent = Intent(this@SeconActivityCal3, CalculationActivity::class.java).putExtra("Level", "1ere")
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())

            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bte3).setOnClickListener {
            val intent = Intent(this@SeconActivityCal3, CalculationActivity::class.java).putExtra("Level", "1ere")
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())

            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

        findViewById<Button>(R.id.bec3).setOnClickListener {
            val intent = Intent(this@SeconActivityCal3, CalculationActivity::class.java).putExtra("Level", "1ere")
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())

            findViewById<ProgressBar>(R.id.progress_loader).isVisible = true
        }

    }

    override fun onResume() {
        super.onResume()
        findViewById<ProgressBar>(R.id.progress_loader).isVisible = false
    }

}