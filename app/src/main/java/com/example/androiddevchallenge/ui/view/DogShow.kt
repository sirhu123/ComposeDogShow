package com.example.androiddevchallenge.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.data.Dog

@Composable
fun DogShow(dogs: List<Dog>, onDogClick: (Dog) -> Unit = {}) {
    LazyColumn(
        Modifier.background(Color.LightGray),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(dogs) { dog ->
            DogItem(dog,
              Modifier
                .clickable {
                  onDogClick(dog)
                }
                .fillMaxWidth())
        }
    }
}

@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {
    Card(modifier) {
        Row {
            Image(
                painterResource(dog.photo),
                "${dog.name} photo",
                Modifier.size(140.dp),
                contentScale = ContentScale.Fit
            )
            Column(Modifier.padding(10.dp)) {
                Text(dog.name, style = MaterialTheme.typography.h3)
                Text(dog.location)
            }
        }
    }
}