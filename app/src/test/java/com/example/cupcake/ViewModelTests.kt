package com.example.cupcake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.viewmodel.OrderViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ViewModelTests {

    // To specify that LiveData objects should not call the main thread
    // we need to provide a specific test rule any time we are testing a LiveData object
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: OrderViewModel

    @Before
    fun setupTest() {
        viewModel = OrderViewModel()
    }

    @Test
    fun quantity_twelve_cupcakes() {
        viewModel.setQuantity(12)
        Assert.assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_27_for_twelve_cupcakes() {
        viewModel.setQuantity(12)
        // 'Transformations' will only be called if we observe the object for changes
        viewModel.price.observeForever {}
        Assert.assertEquals("$27.00", viewModel.price.value)
    }
}