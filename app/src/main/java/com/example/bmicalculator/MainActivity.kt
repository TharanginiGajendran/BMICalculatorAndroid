package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var enterWeight: EditText
    private lateinit var enterHeight: EditText
    private lateinit var result: TextView
    private lateinit var calculate: Button

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
            val weight = enterWeight.text.toString()
            val height = enterHeight.text.toString()
            if (validateInput(weight, height)) {
                try {
                    val square = height.toFloat() * height.toFloat()
                    val finalResult = weight.toFloat() / square
                    result.text = finalResult.toString()
                } catch (ex: NumberFormatException) {
                    Toast.makeText(
                        this,
                        "${ex.localizedMessage} Enter only Numbers",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }
        }

    }

    private fun validateInput(inputWeight: String, inputHeight: String): Boolean {
        when {
            inputWeight.isNullOrEmpty() -> {
                Toast.makeText(this, "Enter value", Toast.LENGTH_LONG).show()
                enterWeight.error = "enter value"
                return false
            }

            inputHeight.isNullOrEmpty() -> {
                Toast.makeText(this, "Enter value", Toast.LENGTH_LONG).show()
                enterHeight.error = "enter value"
                return false
            }
        }
        return true
    }
}

