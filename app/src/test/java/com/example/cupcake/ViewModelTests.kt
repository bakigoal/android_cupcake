package com.example.cupcake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.viewmodel.OrderViewModel
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ViewModelTests {

    // To specify that LiveData objects should not call the main thread
    // we need to provide a specific test rule any time we are testing a LiveData object
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.setQuantity(12)
        Assert.assertEquals(12, viewModel.quantity.value)
    }

}