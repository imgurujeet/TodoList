package com.imgurujeet.todolist.todoApp.data.model

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
data class TodoItem (
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val createdAt: Instant = Instant.fromEpochMilliseconds(0),
)
