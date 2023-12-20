package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var enterWeight: EditText
    private lateinit var enterHeight: EditText
    private lateinit var result: TextView
    private lateinit var calculate: Button
//    private val sqrt = Sqrt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterHeight = findViewById(R.id.etHeight)
        enterWeight = findViewById(R.id.etWeight)
        result = findViewById(R.id.tvResult)
        calculate = findViewById(R.id.calculateBtn)

        viewListeners()
    }

    private fun viewListeners() {
        calculate.setOnClickListener {
            val weight = enterWeight.text.toString().toFloat()
            val height = enterHeight.text.toString().toFloat()
            val square = calculateSqr(height)
                val finalResult = weight / square
                result.text = finalResult.toString()
            }
    }

    private fun calculateSqr(number: Float): Float {
        return number * number
    }
}