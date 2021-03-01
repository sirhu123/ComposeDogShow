package com.example.androiddevchallenge.ui.data

import androidx.annotation.DrawableRes

data class Dog(
    val name: String,
    val age: String,
    val gender: String,
    val location: String,
    @DrawableRes val photo: Int
)
