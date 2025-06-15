package com.example.pizzaoven.di

import com.example.pizzaoven.ui.screen.home.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel { HomeViewModel(get()) }
}