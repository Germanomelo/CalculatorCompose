package com.gmsp.composecalculator.viewmodel

import com.gmsp.composecalculator.view.components.CalculatorAction
import com.gmsp.composecalculator.view.components.CalculatorOperation
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculatorViewModelTest {


    @Test
    fun `when viewmodel adds two numbers then result must be correct`() {
        //Given
        val viewModel = CalculatorViewModel()
        val resultNumber1Success = "3.0"
        val resultNumber2Success = ""
        viewModel.onAction(CalculatorAction.Number(1))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
        viewModel.onAction(CalculatorAction.Number(2))

        //When
        viewModel.onAction(CalculatorAction.Calculate)

        //Then
        assertEquals(resultNumber1Success, viewModel.state.number1)
        assertEquals(resultNumber2Success, viewModel.state.number2)
        assertNull(viewModel.state.operation)
    }

    @Test
    fun `when viewmodel subtract two numbers then result must be correct`() {
        //Given
        val viewModel = CalculatorViewModel()
        val resultNumber1Success = "1.0"
        val resultNumber2Success = ""
        viewModel.onAction(CalculatorAction.Number(3))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
        viewModel.onAction(CalculatorAction.Number(2))

        //When
        viewModel.onAction(CalculatorAction.Calculate)

        //Then
        assertEquals(resultNumber1Success, viewModel.state.number1)
        assertEquals(resultNumber2Success, viewModel.state.number2)
        assertNull(viewModel.state.operation)
    }

    @Test
    fun `when viewmodel multiply two numbers then result must be correct`() {
        //Given
        val viewModel = CalculatorViewModel()
        val resultNumber1Success = "20.0"
        val resultNumber2Success = ""
        viewModel.onAction(CalculatorAction.Number(5))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
        viewModel.onAction(CalculatorAction.Number(4))

        //When
        viewModel.onAction(CalculatorAction.Calculate)

        //Then
        assertEquals(resultNumber1Success, viewModel.state.number1)
        assertEquals(resultNumber2Success, viewModel.state.number2)
        assertNull(viewModel.state.operation)
    }

    @Test
    fun `when viewmodel divide two numbers then result must be correct`() {
        //Given
        val viewModel = CalculatorViewModel()
        val resultNumber1Success = "4.0"
        val resultNumber2Success = ""
        viewModel.onAction(CalculatorAction.Number(20))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
        viewModel.onAction(CalculatorAction.Number(5))

        //When
        viewModel.onAction(CalculatorAction.Calculate)

        //Then
        assertEquals(resultNumber1Success, viewModel.state.number1)
        assertEquals(resultNumber2Success, viewModel.state.number2)
        assertNull(viewModel.state.operation)
    }

    @Test
    fun `when viewmodel delete then one caracter must be deleted`() {
        //Given
        val viewModel = CalculatorViewModel()
        val resultNumber1Success = "2"
        viewModel.onAction(CalculatorAction.Number(20))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))

        //When
        viewModel.onAction(CalculatorAction.Delete)

        //Then
        assertEquals(resultNumber1Success, viewModel.state.number1)
    }

    @Test
    fun `when viewmodel delete operation then the operation must be deleted`() {
        //Given
        val viewModel = CalculatorViewModel()
        viewModel.onAction(CalculatorAction.Number(20))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))

        //When
        viewModel.onAction(CalculatorAction.Delete)

        //Then
        assertNull(viewModel.state.operation)
    }

    @Test
    fun `when viewmodel clear then the variables must be clean`() {
        //Given
        val viewModel = CalculatorViewModel()
        viewModel.onAction(CalculatorAction.Number(10))
        viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
        viewModel.onAction(CalculatorAction.Number(10))

        //When
        viewModel.onAction(CalculatorAction.Clear)

        //Then
        assertEquals("", viewModel.state.number1)
        assertNull(viewModel.state.operation)
        assertEquals("", viewModel.state.number2)
    }


}