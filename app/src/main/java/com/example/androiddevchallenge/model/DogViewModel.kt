package com.example.androiddevchallenge.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.Dog

class DogViewModel : ViewModel() {
  val dogs by mutableStateOf(
    listOf(
      Dog(
        "A", "1", "girl",
        "shenzhen", R.drawable.a
      ),
      Dog(
        "B", "2", "boy",
        "zhengzhou", R.drawable.b
      ),
      Dog(
        "C", "1", "girl",
        "guangzhou", R.drawable.a
      ),
      Dog(
        "D", "3", "boy",
        "zhengzhou", R.drawable.b
      ),
      Dog(
        "E", "1", "girl",
        "haikou", R.drawable.a
      ),
      Dog(
        "F", "2", "boy",
        "sanya", R.drawable.b
      ),
    )
  )

  var detailDog: Dog? by mutableStateOf(null)

  fun goDetail(dog: Dog) {
    detailDog = dog
  }

  fun backSummary() {
    detailDog = null
  }
}