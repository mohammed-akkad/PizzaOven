package com.example.pizzaoven.ui.screen.home.viewModel

data class HomeUiState(
    val selectedSizePizza: TypeSize = TypeSize.Small,
    val ingredientUiState: List<IngredientUiState> = emptyList(),
    val breads: List<Int> = emptyList(),
    val selectedBreadIndex: Int = 0,
    val selectedIngredientsMap: Map<Int, List<Int>> = emptyMap()


)

data class IngredientUiState(
    val itemPizzaIcon: Int = 0,
    val ingredients: List<Int> = emptyList(),
    val isSelected: Boolean = false,
    val breads: Int = 0,
)

enum class TypeSize {
    Small, Medium, Large
}