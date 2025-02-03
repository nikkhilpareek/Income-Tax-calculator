package com.example.taxlab

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.ui.semantics.text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the layout file

        val grossIncome = 1500000

        val tax = taxCalc(grossIncome)

        Log.d("TaxCalculator", "Calculated Tax: $tax & Net Income: ${grossIncome - tax}")

        // Find the TextView in the layout
        val resultTextView = findViewById<TextView>(R.id.resultText)

        // Update the TextView with the calculated tax
        resultTextView.text = "Calculated Tax: $tax"
    }

    fun taxCalc(grossIncome: Int): Float {
        var tax = 0f
        when {
            grossIncome < 400000 -> {
                tax = 0f
            }
            grossIncome in 400000..800000 -> {
                val taxAmnt = grossIncome - 300000
                tax = 5 * taxAmnt / 100f
                tax += 3 * tax / 100f
            }
            grossIncome in 800001..1200000 -> {
                val taxAmnt = grossIncome - 800000
                tax = taxAmnt / 10f + 20000f
                tax += 3 * tax / 100f
            }
            grossIncome in 1200001..1600000 -> {
                val taxAmnt = grossIncome - 1200000
                tax = taxAmnt * 15 / 100f + 60000f
                tax += 3 * tax / 100f
            }
            grossIncome in 1600001..2000000 -> {
                val taxAmnt = grossIncome - 1600000
                tax = taxAmnt / 5f + 120000f
                tax += 3 * tax / 100f
            }
            grossIncome in 2000001..2400000 -> {
                val taxAmnt = grossIncome - 2000000
                tax = taxAmnt / 4f + 200000f
                tax += 3 * tax / 100f
            }
            else -> {
                val taxAmnt = grossIncome - 2400000
                tax = taxAmnt * 3 / 10f + 300000f
                tax += 3 * tax / 100f
            }
        }
        return tax
    }
}