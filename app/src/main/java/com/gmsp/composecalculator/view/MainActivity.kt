package com.gmsp.composecalculator.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gmsp.composecalculator.view.components.Calculator
import com.gmsp.composecalculator.ui.theme.ComposeCalculatorTheme
import com.gmsp.composecalculator.ui.theme.MediumGray
import com.gmsp.composecalculator.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {
                startCalculator()
            }
        }
    }
}

@Preview
@Composable
fun startCalculator() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    val buttonSpacing = 8.dp
    Calculator(
        state = state, onAction = viewModel::onAction,
        buttonSpacing = buttonSpacing,
        modifier = Modifier
            .fillMaxSize()
            .background(MediumGray)
            .padding(16.dp)
    )
}
