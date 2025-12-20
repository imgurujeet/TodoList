package com.imgurujeet.todolist

import com.imgurujeet.todolist.todoApp.data.TodoRepositoryImpl
import com.imgurujeet.todolist.todoApp.domain.TodoRepository
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.dsl.module


private var isKoinInitialized = false

val appModule : Module = module {
   single<TodoRepository>{
       TodoRepositoryImpl()
   }
    factory {

    }
}

fun initKoin(){
    if(!isKoinInitialized){
        startKoin {
            modules(appModule)
        }

        isKoinInitialized = true
        //setup koin
    }
}

fun resetKoin(){
    stopKoin()
    isKoinInitialized = false
    initKoin()
}

