package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat

class CreditsActivity : AppCompatActivity() {
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits)

        val animations = Animations()

        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener{
            val intent = Intent(this@CreditsActivity, MainActivity::class.java)
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent , options.toBundle())
        }
    }
}