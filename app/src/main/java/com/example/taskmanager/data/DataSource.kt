package com.example.taskmanager.data

import androidx.compose.ui.res.stringResource
import com.example.taskmanager.R
import java.util.Date

object DataSource {
    val screens = listOf(
        Screen(
            name = R.string.home
        ),

        Screen(
            name = R.string.create_task
        ),

        Screen(
            name = R.string.work
        )

    )

    var tasks = DefaultTasks();

    val settings = listOf(
        Setting(
            name = "Test",
            desc = "I'm meant to be writing at this moment. But I'm not lmao, cope.",
            settingOn = false,
            subSetting = SubSetting.General
        ),

        Setting(
            name = "Test1",
            desc = "I'm meant to be writing at this moment. But I'm not lmao, cope.2",
            settingOn = true,
            subSetting = SubSetting.General
        )
    )
}

//object ShopItems {
//
//}










fun DefaultTasks(): MutableList<Task> {
    return mutableListOf(
        Task(
            id = 0,
            done  = false,
            name = "Design Lesson Plan",
            description = "Write up a plan for each meeting, detailing how and when each team member will learn about their robotics subteam",
            date = Date(2024, 9, 8),
            category = Robotics(),
            priority = Priority.Low,
            difficulty = Difficulty.Hard
        ),

        Task(
            id = 1,
            done  = false,
            name = "WRITE COLLEGE ESSAYS",
            description = "Write up in a separate doc, get them reviewed by Deb, and paste them into the CommonApp",
            date = Date(2024, 9, 29),
            category = College(),
            priority = Priority.High,
            difficulty = Difficulty.Hard
        ),

        Task(
            id = 2,
            done  = false,
            name = "Work on the Congressional App Challenge",
            description = "Set up each screen, navigation, plan the app out to fulfill impacts, write a video, code!"
            date = Date(2024, 10, 25),
            category = Projects(),
            priority = Priority.High,
            difficulty = Difficulty.Medium
        ),

        Task(
            id = 3,
            done  = false,
            name = "Read \"The Life of Pi\"",
            description = "Read the book given to you by Mr. Nicastro. Return it at a Cricket Club Meeting and discuss it there.",
            date = Date(2025, 6, 8),
            category = Personal(),
            priority = Priority.None,
            difficulty = Difficulty.Easy
        ),

        Task(
            id = 4,
            done  = false,
            name = "Set up Cricket Club Tournament",
            description = "Plan out who's bringing what, decide on timings\n" +
                    "maybe make Jerseys as a way to pay for the tournament?\n" +
                    "Decide on the future of Cricket Club from there.",
            date = Date(2024,10,5),
            category = Clubs(),
            priority = Priority.High,
            difficulty = Difficulty.Medium

        )
    )
}