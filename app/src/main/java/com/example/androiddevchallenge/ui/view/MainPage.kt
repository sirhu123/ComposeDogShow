package com.example.androiddevchallenge.ui.view

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.model.DogViewModel
import kotlinx.coroutines.launch

@Composable
fun MainPage() {
    val snackbarState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(topBar = {
        TopAppBar(title = {
            Text("Dog Show")
        }, backgroundColor = Color.White)
    },
        snackbarHost = {
            SnackbarHost(snackbarState)
        }) {
        val viewModel: DogViewModel = viewModel()
        DogShow(viewModel.dogs) { dog ->
            viewModel.goDetail(dog)
        }
        val dog = viewModel.detailDog
        if (dog != null) {
            DogInformation(dog) {
                coroutineScope.launch {
                    snackbarState.showSnackbar("You have liked ${dog.name}")
                }
            }
        }
    }
}