package com.imgurujeet.todolist.todoApp.domain

import com.imgurujeet.todolist.todoApp.data.model.TodoItem

interface TodoRepository {
    suspend fun getTodo(): List<TodoItem>
    suspend fun addTodo(todo: TodoItem)
    suspend fun updateTodo(todo: TodoItem)
    suspend fun deleteTodo(todo: TodoItem)
}