package com.imgurujeet.todolist

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform