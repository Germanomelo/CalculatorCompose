package com.gmsp.composecalculator.view.components

import com.gmsp.composecalculator.view.components.CalculatorOperation

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null
)
