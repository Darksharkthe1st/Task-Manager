package com.example.taskmanager.data

import androidx.annotation.ColorRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.taskmanager.R
import java.util.Date

enum class Priority(
    @ColorRes val color: Int
) {
    Low(R.color.Low_Color),
    Medium(R.color.Medium_Color),
    High(R.color.High_Color),
    None(R.color.None_Color)
}

enum class Category(
    @ColorRes val color: Int
) {
    Robotics(R.color.Robotics_Category),
    College(R.color.College_Category),
    Projects(R.color.Projects_Category),
    Personal(R.color.Personal_Category),
    Clubs(R.color.Clubs_Category)
}

data class Task(
    val name: String,
    val desc: String,
    val date: Date,
    val category: Category,
    val priority: Priority
)
