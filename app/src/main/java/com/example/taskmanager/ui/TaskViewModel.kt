package com.example.taskmanager.ui

import android.graphics.Point
import androidx.lifecycle.ViewModel
import com.example.taskmanager.data.TaskUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskViewModel : ViewModel() {
    operator fun invoke(): TaskViewModel {
        return TaskViewModel()
    }

    //Saved values of the UI:
    private val _uiState = MutableStateFlow(TaskUiState(1))
    val uiState: StateFlow<TaskUiState> = _uiState.asStateFlow()


}