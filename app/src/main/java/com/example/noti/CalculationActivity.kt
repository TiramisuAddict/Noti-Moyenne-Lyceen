package com.example.noti

import androidx.appcompat.app.AppCompatActivity
import com.google.gson.reflect.TypeToken
import android.widget.LinearLayout
import java.io.InputStreamReader
import android.widget.TextView
import android.widget.CheckBox
import android.widget.EditText
import android.content.Intent
import android.widget.Button
import com.google.gson.Gson
import android.os.Bundle
import java.io.File

class CalculationActivity : AppCompatActivity() {

    private fun addInfoToJsonFile(historyTab: History) {
        val gson = Gson()
        val file = File(getExternalFilesDir(null), "History.json")

        if (!file.exists()) file.createNewFile()

        val existingJson = file.readText()
        val type = object : TypeToken<MutableList<History>>() {}.type
        val historyList: MutableList<History> = if (existingJson.isNotBlank()) {
            gson.fromJson(existingJson, type)
        } else mutableListOf()

        historyList.add(historyTab)

        val updatedJson = gson.toJson(historyList)
        file.writeText(updatedJson)
    }

    private fun totalAverage(subjects: List<Subjects>): Float {
        var sum = 0.0
        var sumCoefficients = 0
        for (subject in subjects) {
            if (!subject.isDispensed) {
                sum += subject.average.toDouble() * subject.coefficient
                sumCoefficients += subject.coefficient
            }
        }
        return (sum / sumCoefficients).toFloat()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)

        //val levelsNumber = 3
        val levelName = intent.getStringExtra("Level")

        val levelText = findViewById<TextView>(R.id.LevelText)
        levelText.text = levelName

        val parentLayout = findViewById<LinearLayout>(R.id.cardContainer)

        data class Subject(
            val subjectId: Int,
            val subjectName: String,
            val numberOfFields: Int,
            val coefficient: Int,
            val examCoefficients: List<Int>,
            val editTextIds: List<String>,
            val resultTextViewId: String,
            val editTextPlaceHolders: MutableList<String>,
            val checkBoxId: String
        )

        data class Level(
            val levelId: Int,
            val name: String,
            val subjectsNumber: Int,
            val subjects: List<Subject>
        )

        val gson = Gson()
        val inputStream = assets.open("AcademicLevels.json") //AcademicLevels.json
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Level>>() {}.type
        val levelList: List<Level> = gson.fromJson(reader, type)

        val subjectsTab = mutableListOf<Subjects>()

        for(j in 0 until 4){
            if (levelList[j].name == levelName){
                for(i in 0 until levelList[j].subjectsNumber){
                    val card = Card(
                        subjectId = levelList[j].subjects[i].subjectId,
                        subjectName = levelList[j].subjects[i].subjectName,
                        numberOfFields = levelList[j].subjects[i].numberOfFields,
                        coefficient = levelList[j].subjects[i].coefficient,
                        examCoefficients = mutableListOf<Int>().apply { addAll(levelList[j].subjects[i].examCoefficients) },
                        editTextIds = mutableListOf<String>().apply { addAll(levelList[j].subjects[i].editTextIds) },
                        editTextPlaceHolders = mutableListOf<String>().apply { addAll(levelList[j].subjects[i].editTextPlaceHolders) },
                        resultTextViewId = levelList[j].subjects[i].resultTextViewId,
                        checkBoxId = levelList[j].subjects[i].checkBoxId
                    )

                    val cardView = card.createCardLayout(this)
                    parentLayout.addView(cardView)

                    val editTextsList = mutableListOf<EditText>()
                    val resultTextView = findViewById<TextView>(card.resultTextViewId.hashCode())
                    val checkBox = findViewById<CheckBox>(card.checkBoxId.hashCode())

                    for(k in 0 until card.numberOfFields){
                        val x = findViewById<EditText>(card.editTextIds[k].hashCode())
                        editTextsList.add(x)
                    }

                    subjectsTab.add(Subjects(card.subjectName, card.subjectId, card.coefficient, "0.0", false))

                    card.updateResult(editTextsList, resultTextView, subjectsTab[card.subjectId])
                    card.updateDispense(this, checkBox, editTextsList, resultTextView, subjectsTab[card.subjectId])
                }
                break
            }
        }

        val calculateButton = findViewById<Button>(R.id.CalculateButton)

        calculateButton.setOnClickListener {
            val finalResult = totalAverage(subjectsTab)
            val historyInfo = History(
                title = levelText.text.toString(),
                subjectCount = subjectsTab.size,
                gradesList = subjectsTab.map { Grades(it.subjectName, it.average) },
                finalAverage = String.format("%.2f", finalResult),
            )
            addInfoToJsonFile(historyInfo)

            startActivity(
                Intent(this@CalculationActivity, ResActivity::class.java).putExtra("Moy" ,String.format("%.2f", finalResult))
            )
        }

    }
}