package com.example.pizzaoven.ui.screen.home.compose

import androidx.compose.runtime.Composable
import com.example.pizzaoven.ui.screen.home.viewModel.HomeUiState
import com.example.pizzaoven.ui.screen.home.viewModel.TypeSize

@Composable
fun SmallCardPizza(
    state: HomeUiState,
    onSizeSelected: (TypeSize) -> Unit,
) {
    CardPizzaSize(
        text = "S",
        state = state,
        typeSize = TypeSize.Small,
        onSizeSelected = { onSizeSelected(it) })
}