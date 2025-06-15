package com.example.pizzaoven.ui.screen.home.compose

import androidx.compose.runtime.Composable
import com.example.pizzaoven.ui.screen.home.viewModel.HomeUiState
import com.example.pizzaoven.ui.screen.home.viewModel.TypeSize

@Composable
fun LargeCardPizza(
    state: HomeUiState,
    onSizeSelected: (TypeSize) -> Unit,
) {
    CardPizzaSize(
        text = "L",
        state = state,
        typeSize = TypeSize.Large,
        onSizeSelected = { onSizeSelected(it) }
    )
}