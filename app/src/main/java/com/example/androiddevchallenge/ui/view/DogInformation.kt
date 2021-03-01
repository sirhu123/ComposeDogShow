package com.example.androiddevchallenge.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.data.Dog

@Composable
fun DogInformation(dog: Dog, onLike: (Dog) -> Unit = {}) {
    Column(
      Modifier
        .fillMaxSize()
        .background(Color.LightGray)
    ) {
        Box {
            Image(
                painterResource(dog.photo),
                "${dog.name} photo",
                Modifier.aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Button(
                { onLike(dog) },
              Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp)
            ) {
                Text(text = "Like")
            }
        }
        Column(Modifier.padding(10.dp, 6.dp)) {
            Text("Name: ${dog.name}", style = MaterialTheme.typography.h3)
            ProvideTextStyle(MaterialTheme.typography.h5) {
                Text("Age: ${dog.age}")
                Text("Gender: ${dog.gender}")
                Text("Location: ${dog.location}")
            }
        }
    }
}