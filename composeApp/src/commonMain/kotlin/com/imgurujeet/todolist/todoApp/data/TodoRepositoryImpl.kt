package com.imgurujeet.todolist.todoApp.data

import com.imgurujeet.todolist.todoApp.data.model.TodoItem
import com.imgurujeet.todolist.todoApp.domain.TodoRepository

class TodoRepositoryImpl: TodoRepository {

    private val todo = mutableListOf<TodoItem>()

    override suspend fun getTodo(): List<TodoItem> {
        return todo.toList()
    }
    override suspend fun addTodo(todo: TodoItem) {
        this.todo.add(todo)
    }
    override suspend fun updateTodo(todo: TodoItem) {
        val index = this.todo.indexOfFirst { it.id == todo.id }
        if (index != -1) {
            this.todo[index] = todo
        }
    }
    override suspend fun deleteTodo(todo: TodoItem) {
        this.todo.removeAll { it.id == todo.id}
    }

}