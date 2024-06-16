package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import com.google.gson.reflect.TypeToken
import android.widget.LinearLayout
import android.widget.Button
import com.google.gson.Gson
import android.os.Bundle
import java.io.File

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val gson = Gson()

        val file = File(getExternalFilesDir(null), "History.json")

        val clearButton = findViewById<Button>(R.id.ClearButton)

        clearButton.setOnClickListener {
            file.writeText("")
            finish()
            startActivity(intent)
        }

        if (file.exists()) {
            val existingJson = file.readText()

            if (existingJson.isNotBlank()) {
                val type = object : TypeToken<List<History>>() {}.type
                val historyList: List<History> = gson.fromJson(existingJson, type) ?: emptyList()

                val cardContainer = findViewById<LinearLayout>(R.id.HistoryCardContainer)

                for (i in historyList.indices) {
                    val card = HistoryCard(
                        title = historyList[i].title,
                        subjectCount = historyList[i].subjectCount,
                        gradesList = historyList[i].gradesList,
                        finalGrade = historyList[i].finalAverage
                    )

                    val cardView = card.createHistoryCardLayout(this)
                    cardContainer.addView(cardView)
                }
            }
        }

    }
}
