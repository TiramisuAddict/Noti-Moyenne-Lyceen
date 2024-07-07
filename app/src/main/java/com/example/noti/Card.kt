package com.example.noti

import androidx.core.content.res.ResourcesCompat
import androidx.core.content.ContextCompat
import android.content.res.ColorStateList
import androidx.cardview.widget.CardView
import android.widget.LinearLayout
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.CheckBox
import android.content.Context
import android.text.InputType
import android.graphics.Color
import android.text.Editable
import android.view.Gravity
import android.view.View

import android.animation.AnimatorSet
import android.animation.ObjectAnimator

data class Subjects(
    var subjectName: String,
    var subjectId: Int,
    var coefficient: Int,
    var average: String,
    var isDispensed: Boolean
)

class Card(
    val subjectId: Int,
    var subjectName: String,
    var numberOfFields: Int,
    val coefficient: Int,
    val examCoefficients: MutableList<Int> = MutableList(5) { 0 },
    val editTextIds: MutableList<String> = MutableList(5) { "" },
    val editTextPlaceHolders: MutableList<String> = MutableList(5) { "" },
    val resultTextViewId: String,
    val checkBoxId: String
)

{

    fun animateCardPop(view: View, delay: Long) {
        val scaleUpX = ObjectAnimator.ofFloat(view, "scaleX", 0.96f).apply {
            duration = 350
        }
        val scaleUpY = ObjectAnimator.ofFloat(view, "scaleY", 0.96f).apply {
            duration = 350
        }
        val scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", 1f).apply {
            duration = 250
        }
        val scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 1f).apply {
            duration = 250
        }

        AnimatorSet().apply {
            play(scaleUpX).with(scaleUpY)
            play(scaleDownX).with(scaleDownY).after(scaleUpX)
            this.startDelay = delay
            start()
        }
    }

    private fun Context.dpToPx(dp: Int): Int {
        val density = resources.displayMetrics.density
        return (dp * density).toInt()
    }

    fun createCardLayout(context: Context): CardView {
        val typeface = ResourcesCompat.getFont(context, R.font.fredoka_semibold)

        val editTexts = mutableListOf<EditText>()

        val cardView = CardView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                840,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER
                bottomMargin = context.dpToPx(20)
            }
            radius = 40f
            cardElevation = 8f
        }

        val cardColor = ContextCompat.getColor(context, R.color.white)
        cardView.setCardBackgroundColor(cardColor)

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

        //LinearLayout (Horizontal)
        val linearLayoutHorizontal = LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            orientation = LinearLayout.HORIZONTAL
        }
        linearLayout.addView(linearLayoutHorizontal)

        val checkBox = CheckBox(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                leftMargin = context.dpToPx(7)
            }
            id = checkBoxId.hashCode()
        }


        val coefficientTextView = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            ).apply{
                rightMargin = context.dpToPx(18)
            }
            text = coefficient.toString()
            gravity = Gravity.END or Gravity.CENTER_VERTICAL
            textSize = 18f
        }
        linearLayoutHorizontal.addView(checkBox)

        coefficientTextView.typeface = typeface
        coefficientTextView.setTextColor(Color.parseColor("#1B385C"))

        linearLayoutHorizontal.addView(coefficientTextView)

        //LinearLayout (For Inputs)
        val inputsLinearLayout = LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            orientation = LinearLayout.VERTICAL
        }
        linearLayout.addView(inputsLinearLayout)

        val titleTextView = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            ).apply{
                topMargin = context.dpToPx(5)
                bottomMargin = context.dpToPx(5)
            }
            gravity = Gravity.CENTER
            text = subjectName
            textSize = 24f
        }
        titleTextView.typeface = typeface
        titleTextView.setTextColor(Color.parseColor("#1B385C"))

        inputsLinearLayout.addView(titleTextView)

        for (i in 0..4) {
            val editText = EditText(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    430,
                    LinearLayout.LayoutParams.MATCH_PARENT
                ).apply{
                    gravity = Gravity.CENTER
                    topMargin = context.dpToPx(6)
                    id = editTextIds[i].hashCode()
                    error = null
                    hint = editTextPlaceHolders[i]
                }
                inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
                visibility = if (i+1 <=  numberOfFields) View.VISIBLE else View.GONE

                editTexts.add(this)
                setTextColor(Color.parseColor("#1B385C"))
            }

            val editTextLineColor = ColorStateList.valueOf(Color.parseColor("#1B385C"))
            editText.backgroundTintList = editTextLineColor

            linearLayout.addView(editText)
        }

        val resultTextView = TextView(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply{
                topMargin = context.dpToPx(10)
                bottomMargin = context.dpToPx(15)
            }

            text = "0.0"
            gravity = Gravity.CENTER
            textSize = 24f

            id = resultTextViewId.hashCode()
        }
        resultTextView.typeface = typeface
        resultTextView.setTextColor(Color.parseColor("#1B385C"))

        linearLayout.addView(resultTextView)
        return cardView
    }

    fun averageCalculation(editTexts: List<EditText>):String{
        var sum = 0.0
        for(i in 0 until numberOfFields){
            sum += editTexts[i].text.toString().toDouble() * examCoefficients[i]
        }

        val average = sum / examCoefficients.sum()
        return String.format("%.2f", average)
    }

    fun updateResult (editTexts: List<EditText>, resultTextView: TextView, subjectsList: Subjects){
        for(editText in editTexts){
            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {
                    // Check if all the EditText fields are not empty
                    if (editTexts.all { it.text.toString() != "" }) {
                        resultTextView.text = averageCalculation(editTexts)
                        subjectsList.average = resultTextView.text.toString()
                    }else{
                        resultTextView.text = "0.0"
                        subjectsList.average = resultTextView.text.toString()
                    }
                }
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (editText.text.toString() != "" ) {
                        if(editText.text.toString().toDouble() > 20){
                            editText.error = "La note ne doit pas dépasser 20"
                        }
                    }
                }
            })
        }
    }

    fun updateDispense(context: Context, checkBox: CheckBox, editTexts: List<EditText>, resultTextView: TextView, subjectsList: Subjects) {
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                subjectsList.isDispensed = true

                for (editText in editTexts) {
                    editText.isEnabled = false
                }
                resultTextView.text = context.getString(R.string.dispense)
                resultTextView.setTextColor(Color.parseColor("#CD4236"))
            } else {
                subjectsList.isDispensed = false

                for (editText in editTexts) {
                    editText.isEnabled = true
                }
                resultTextView.setTextColor(Color.parseColor("#1B385C"))
                if(editTexts.all { it.text.toString() != "" }){
                    resultTextView.text = averageCalculation(editTexts)
                    subjectsList.average = resultTextView.text.toString()
                }else{
                    resultTextView.text = "0.0"
                    subjectsList.average = resultTextView.text.toString()
                }
            }

        }
    }
}