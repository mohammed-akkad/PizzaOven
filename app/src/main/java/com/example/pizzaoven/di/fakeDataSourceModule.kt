package com.example.pizzaoven.di

import com.example.pizzaoven.data.FakeData
import org.koin.dsl.module

val fakeDataModule = module {

    single {
        FakeData()
    }

}