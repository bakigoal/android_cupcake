package com.example.cupcake.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private var _quantity = MutableLiveData(0)
    val quality: LiveData<Int> = _quantity

    private var _flavor = MutableLiveData("")
    val flavor: LiveData<String> = _flavor

    private var _date = MutableLiveData("")
    val date: LiveData<String> = _date

    private var _price = MutableLiveData(0.0)
    val price: LiveData<Double> = _price

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
    }

    fun setFlavor(flavor: String) {
        _flavor.value = flavor
    }

    fun setPickupDate(date: String) {
        this._date.value = date
    }

    fun setPrice(price: Double) {
        _price.value = price
    }

    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }
}