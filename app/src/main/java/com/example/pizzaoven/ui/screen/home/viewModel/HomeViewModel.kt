package com.example.pizzaoven.ui.screen.home.viewModel

import androidx.lifecycle.ViewModel
import com.example.pizzaoven.data.FakeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val fakeData: FakeData
) : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getBread()
    }

    private fun getBread() {
        val getBread = fakeData.getBread()
        val response = fakeData.getIngredient()
        _state.update {
            it.copy(
                breads = getBread,
                ingredientUiState = response
            )
        }
    }

    fun selectedBread(index: Int) {
        _state.update { currentState ->
            val selectedIngredients = currentState.selectedIngredientsMap[index] ?: emptyList()
            val updatedIngredients = currentState.ingredientUiState.map { existingIngredient ->
                val isSelected = selectedIngredients.contains(existingIngredient.itemPizzaIcon)
                existingIngredient.copy(isSelected = isSelected)
            }
            currentState.copy(
                selectedBreadIndex = index,
                ingredientUiState = updatedIngredients
            )
        }
    }


    fun selectedSize(size: TypeSize) {
        when (size) {
            TypeSize.Small -> {
                _state.update { it.copy(selectedSizePizza = size) }
            }

            TypeSize.Medium -> {
                _state.update { it.copy(selectedSizePizza = size) }
            }

            TypeSize.Large -> {
                _state.update { it.copy(selectedSizePizza = size) }
            }
        }
    }


    fun isSelectedIngredient(item: IngredientUiState) {
        _state.update { currentState ->
            val updatedIngredients = currentState.ingredientUiState.map { existingIngredient ->
                if (existingIngredient == item) {
                    val isSelected = !existingIngredient.isSelected
                    existingIngredient.copy(isSelected = isSelected)
                } else {
                    existingIngredient
                }
            }

            val selectedIngredients = updatedIngredients
                .filter { it.isSelected }
                .map { it.itemPizzaIcon }

            val updatedMap = currentState.selectedIngredientsMap.toMutableMap()
            updatedMap[currentState.selectedBreadIndex] = selectedIngredients

            currentState.copy(
                ingredientUiState = updatedIngredients,
                selectedIngredientsMap = updatedMap
            )
        }
    }
}