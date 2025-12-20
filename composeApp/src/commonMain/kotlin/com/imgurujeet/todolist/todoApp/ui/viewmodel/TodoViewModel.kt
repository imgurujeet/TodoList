package com.imgurujeet.todolist.todoApp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imgurujeet.todolist.todoApp.data.model.TodoItem
import com.imgurujeet.todolist.todoApp.domain.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(
    private val todoRepository: TodoRepository
): ViewModel() {

    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    val todos : StateFlow<List<TodoItem>> = _todos


    private fun loadTodos(){
        viewModelScope.launch {
            _todos.value = todoRepository.getTodo()
        }

    }

    fun addTodo(todo: TodoItem){
        viewModelScope.launch {
            todoRepository.addTodo(todo)
            loadTodos()
        }
    }

    fun deleteTodo(todo: TodoItem){
        viewModelScope.launch {
            todoRepository.deleteTodo(todo)
            loadTodos()
        }
    }

    fun updateTodo(todo: TodoItem){
        viewModelScope.launch {
            todoRepository.updateTodo(todo)
            loadTodos()
        }
    }





}