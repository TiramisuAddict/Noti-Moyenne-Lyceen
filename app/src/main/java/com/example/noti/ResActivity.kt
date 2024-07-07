package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat

class ResActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var menuButton: Button

    private fun saveData() {
        val sharedPrefrences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPrefrences.edit()

        editor.apply {
            putString("STRING_KEY", resultTextView.text.toString())
        }.apply()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res)

        val animations = Animations()

        resultTextView = findViewById(R.id.resultText)
        menuButton = findViewById(R.id.menuButton)

        resultTextView.text = intent.getStringExtra("Moy")

        menuButton.setOnClickListener {
            finish()
            val intent = Intent(this, MainActivity::class.java)
            val options = animations.swipeEffect(this, "swipeRight")
            startActivity(intent, options.toBundle())

            saveData()
        }
    }
}