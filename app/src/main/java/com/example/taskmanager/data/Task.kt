package com.example.taskmanager.data

import androidx.annotation.ColorRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.taskmanager.R
import java.util.Date
import java.util.Vector

enum class Priority(
    @ColorRes val color: Int
) {
    Low(R.color.Low_Color),
    Medium(R.color.Medium_Color),
    High(R.color.High_Color),
    None(R.color.None_Color)
}

enum class Difficulty(
    @ColorRes val color: Int
) {
    Easy(R.color.Low_Color),
    Medium(R.color.Medium_Color),
    Hard(R.color.High_Color),
    None(R.color.None_Color)
}

data class Category(
    var name: String,
    @ColorRes val color: Int,
)

data class Task(
    val id: Int,
    var done: Boolean,
    val name: String,
    val description: String,
    val date: Date,
    val category: Category,
    val priority: Priority,
    val difficulty: Difficulty
)



public fun Robotics() : Category{
    return Category("Robotics", R.color.Robotics_Category)
}

public fun College() : Category {
    return Category("College", R.color.College_Category)
}

public fun Projects() : Category{
    return Category("Projects", R.color.Projects_Category)
}

public fun Personal() : Category{
    return Category("Personal", R.color.Personal_Category)
}

public fun Clubs() : Category{
    return Category("Clubs", R.color.Clubs_Category)
}
