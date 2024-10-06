package com.example.taskmanager.data

enum class SubSetting {
    General
}

data class Setting(
    val name: String,
    val desc: String,
    var settingOn: Boolean,
    val subSetting: SubSetting
)