package com.example.taskmanager.data

import java.util.Date

object DataSource {
    val tasks = listOf(
        Task(
            name = "Design Lesson Plan",
            desc = "Write up a plan for each meeting, detailing how and when each team member will learn about their robotics subteam",
            date = Date(2024, 9, 8),
            category = Category.Robotics,
            priority = Priority.Low
        ),

        Task(
            name = "WRITE COLLEGE ESSAYS",
            desc = "Write up in a separate doc, get them reviewed by Deb, and paste them into the CommonApp",
            date = Date(2024, 9, 29),
            category = Category.College,
            priority = Priority.High
        ),

        Task(
            name = "Work on the Congressional App Challenge",
            desc = "Write up a plan for each meeting, detailing how and when each team member will learn about their robotics subteam",
            date = Date(2024, 10, 25),
            category = Category.Projects,
            priority = Priority.High
        ),

        Task(
            name = "Read \"The Life of Pi\"",
            desc = "Read the book given to you by Mr. Nicastro. Return it at a Cricket Club Meeting and discuss it there.",
            date = Date(2025, 6, 8),
            category = Category.Personal,
            priority = Priority.None
        ),

        Task(
            name = "Set up Cricket Club Tournament",
            desc = "Plan out who's bringing what, decide on timings\n" +
                    "maybe make Jerseys as a way to pay for the tournament?\n" +
                    "Decide on the future of Cricket Club from there.",
            date = Date(2024,10,5),
            category = Category.Clubs,
            priority = Priority.High

        )
    )

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