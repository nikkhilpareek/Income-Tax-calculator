package com.example.taxlab

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var income: EditText
    lateinit var result: TextView
    lateinit var taxTextView: TextView
    lateinit var calc: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        income = findViewById(R.id.et_income)
        result = findViewById(R.id.result_tv)
        taxTextView = findViewById(R.id.tv_tax)
        calc = findViewById(R.id.btn_tax)
        calc.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_tax) {
            val Income = income.text.toString().toIntOrNull() ?: 0
            val calculatedTax = taxCalc(Income-75000)
            val netIncome = Income - calculatedTax

            result.text = "Net Income: $netIncome"
            taxTextView.text = "Tax: $calculatedTax"
        }
    }

    fun taxCalc(grossIncome: Int): Float {
        var tax = 0f
        when {
            grossIncome < 400000 -> {
                tax = 0f
            }
            grossIncome in 400000..800000 -> {
                val taxAmnt = grossIncome - 30000f
                tax = 5 * taxAmnt / 100f
                tax += 3 * tax/100f
            }
            grossIncome in 800001..1200000 -> {
                val taxAmnt = grossIncome - 800000
                tax = taxAmnt * 10 / 100f + 20000f
                tax += 3 * tax/100f
            }
            grossIncome in 1200001..1600000 -> {
                val taxAmnt = grossIncome - 1200000
                tax = taxAmnt * 15 / 100f + 60000f
                tax += 3 * tax/100f
            }
            grossIncome in 1600001..2000000 -> {
                val taxAmnt = grossIncome - 1600000
                tax = taxAmnt * 20 / 100f + 120000f
                tax += 3 * tax/100f
            }
            grossIncome in 2000001..2400000 -> {
                val taxAmnt = grossIncome - 2000000
                tax = taxAmnt * 25 / 100f + 200000f
                tax += 3 * tax/100f
            }
            else -> {
                val taxAmnt = grossIncome - 2400000
                tax = taxAmnt * 30 / 100f + 300000f
                tax += 3 * tax/100f
            }
        }
        return tax
    }



}