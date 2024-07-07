package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import android.widget.ProgressBar
import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat

class SeconActivity : AppCompatActivity() {
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secon)

        val animations = Animations()

        findViewById<ProgressBar>(R.id.progress_loader).isVisible = false

        findViewById<Button>(R.id.button1ere).setOnClickListener {
            val intent = Intent(this@SeconActivity, CalculationActivity::class.java).putExtra("Level", "1ere")
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())
        }

        findViewById<Button>(R.id.button2eme).setOnClickListener {
            val intent = Intent(this@SeconActivity, SeconActivityCal2::class.java)
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())
        }

        findViewById<Button>(R.id.button3eme).setOnClickListener {
            val intent = Intent(this@SeconActivity, SeconActivityCal3::class.java)
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())
        }

        findViewById<Button>(R.id.button4eme).setOnClickListener {
            val intent = Intent(this@SeconActivity, SeconActivityCal4::class.java)
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())
        }

    }

}