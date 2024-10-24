package com.example.taskmanager.ui

import android.provider.ContactsContract.Data
import androidx.lifecycle.ViewModel
import com.example.taskmanager.data.DataSource
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

    //Used to remove a task from the list
    public fun onTaskDone(id: Int) {
        println("I RAN!")
        var n: Int = 0
        val size: Int = DataSource.tasks.size - 1
        for (k in 0..size) {
            if (DataSource.tasks[k].id == id) {
                DataSource.tasks.removeAt(k)
                return
            }
        }
        n++
    }

    public fun makeID(): Int {

        var n: Int = 0
        var bool: Boolean = false
        while (!bool) {
            bool = true
            for (t in DataSource.tasks) {
                if (t.id == n) {
                    bool = false
                    break;
                }
            }
        }

        return n

    }

}