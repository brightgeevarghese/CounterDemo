package edu.miu.counterdemo.ui

data class CounterUIState(
    val isLoading: Boolean = false,
    val counter: Int = 0,
    val errorMessage: String? = null
)
