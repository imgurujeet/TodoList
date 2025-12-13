package com.imgurujeet.todolist

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.dsl.module


private var isKoinInitialized = false

val appModule : Module = module {
   single {
        //setup viewmodel or classes
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

