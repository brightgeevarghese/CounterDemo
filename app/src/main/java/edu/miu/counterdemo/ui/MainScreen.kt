package edu.miu.counterdemo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainScreenViewModel: MainScreenViewModel = viewModel()
) {
    val countState = mainScreenViewModel.counter.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { mainScreenViewModel.increment() }) {
            Text(text = "Increment")
        }
        val state = countState.value
        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }
            state.errorMessage != null -> {
                Text(text = state.errorMessage)
            }
            else -> {
                Text(text = "${state.counter}")
            }
        }
        Button(onClick = { mainScreenViewModel.decrement() }) {
            Text(text = "Decrement")
        }
    }
}