package edu.miu.counterdemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel: ViewModel() {
    private var _counter = MutableStateFlow(CounterUIState(isLoading = true))
    val counter = _counter.asStateFlow()

    init {
        viewModelScope.launch {
            // Simulate loading state for 2 seconds
            delay(2000L)
            _counter.value = CounterUIState(isLoading = false, counter = 0)
        }
    }

    var increment = {
        viewModelScope.launch {
            _counter.value.let {
                _counter.value = it.copy(counter = it.counter.plus(1))
            }
        }
    }
    var decrement = {
        viewModelScope.launch {
            _counter.value.let {
                _counter.value = it.copy(counter = it.counter.minus(1))
            }
        }
    }
}

