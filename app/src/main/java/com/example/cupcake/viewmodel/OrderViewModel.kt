package com.example.cupcake.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderViewModel : ViewModel() {

    private var _quantity = MutableLiveData(0)
    val quality: LiveData<Int> = _quantity

    private var _flavor = MutableLiveData("")
    val flavor: LiveData<String> = _flavor

    private var _date = MutableLiveData("")
    val date: LiveData<String> = _date

    private var _price = MutableLiveData(0.0)
    val price: LiveData<Double> = _price

    val dateOptions = getPickupOptions()

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
    }

    fun setFlavor(flavor: String) {
        _flavor.value = flavor
    }

    fun setDate(date: String) {
        this._date.value = date
    }

    fun setPrice(price: Double) {
        _price.value = price
    }

    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        // Create a list of dates starting with the current date and the following 3 dates
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }
}