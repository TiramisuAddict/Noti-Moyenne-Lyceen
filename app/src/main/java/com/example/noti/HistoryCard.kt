package com.example.noti

import androidx.core.content.res.ResourcesCompat
import androidx.cardview.widget.CardView
import android.widget.LinearLayout
import android.content.Context
import android.widget.TextView
import android.graphics.Color
import android.view.Gravity

data class History(
    val title: String,
    val subjectCount: Int,
    val gradesList: List<Grades>,
    val finalAverage: String
)

data class Grades (
    val subjectName : String,
    val grade : String
)

class HistoryCard (
    val title : String,
    val subjectCount : Int,
    val gradesList : List<Grades>,
    val finalGrade : String
) {
    private fun Context.dpToPx(dp: Int): Int {
        val density = resources.displayMetrics.density
        return (dp * density).toInt()
    }

    fun createHistoryCardLayout (context: Context) : CardView{
        val fredokaSemiBold = ResourcesCompat.getFont(context, R.font.fredoka_semibold)
        val fredokaRegular = ResourcesCompat.getFont(context, R.font.fredoka_regular)

        val cardView = CardView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                840,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER
                topMargin = context.dpToPx(10)
                bottomMargin = context.dpToPx(10)

                setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            }
            radius = 40f
            cardElevation = 8f
        }

        //LinearLayout (Vertical)
        val linearLayout = LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            ).apply{
                topMargin = context.dpToPx(8)
            }
            orientation = LinearLayout.VERTICAL
        }
        cardView.addView(linearLayout)

        val levelTextView = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            ).apply {
                topMargin = context.dpToPx(16)
            }
            text = title
            gravity = Gravity.CENTER
            textSize = 28f
        }
        levelTextView.typeface = fredokaSemiBold
        levelTextView.setTextColor(Color.parseColor("#1B385C"))

        linearLayout.addView(levelTextView)

        //LinearLayout (Horizontal)
        val dataLinearLayout = LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            ).apply{
                topMargin = context.dpToPx(8)
                rightMargin = context.dpToPx(40)
                leftMargin = context.dpToPx(40)
            }
            orientation = LinearLayout.HORIZONTAL
        }
        linearLayout.addView(dataLinearLayout)

        val subjectLinearLayout = LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            gravity = Gravity.START
            orientation = LinearLayout.VERTICAL
        }
        dataLinearLayout.addView(subjectLinearLayout)

        val gradeLinearLayout = LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            gravity = Gravity.END
            orientation = LinearLayout.VERTICAL
        }
        dataLinearLayout.addView(gradeLinearLayout)

        for (i in 0 until subjectCount){

            val subjectTextView = TextView(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                text = gradesList[i].subjectName
                textSize = 24f
            }
            subjectTextView.typeface = fredokaSemiBold
            subjectTextView.setTextColor(Color.parseColor("#1B385C"))
            subjectLinearLayout.addView(subjectTextView)

            val gradeTextView = TextView(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                ).apply {
                    leftMargin = context.dpToPx(30)
                    topMargin = context.dpToPx(6)
                }
                text = gradesList[i].grade
                gravity = Gravity.CENTER_VERTICAL
                textSize = 20f
            }
            gradeTextView.typeface = fredokaRegular
            gradeTextView.setTextColor(Color.parseColor("#1B385C"))
            gradeLinearLayout.addView(gradeTextView)
        }

        val resultTextView = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            ).apply {
                topMargin = context.dpToPx(16)
                bottomMargin = context.dpToPx(16)
            }
            text = finalGrade
            gravity = Gravity.CENTER
            textSize = 28f
        }
        resultTextView.typeface = fredokaSemiBold
        resultTextView.setTextColor(Color.parseColor("#1B385C"))

        linearLayout.addView(resultTextView)

        return cardView
    }
}

