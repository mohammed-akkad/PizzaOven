package com.example.pizzaoven

import android.app.Application
import com.example.pizzaoven.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PizzaOvenApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PizzaOvenApp)
            modules(appModule)
        }
    }
}