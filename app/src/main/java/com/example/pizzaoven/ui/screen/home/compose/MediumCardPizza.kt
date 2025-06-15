package com.example.pizzaoven.ui.screen.home.compose

import androidx.compose.runtime.Composable
import com.example.pizzaoven.ui.screen.home.viewModel.HomeUiState
import com.example.pizzaoven.ui.screen.home.viewModel.TypeSize

@Composable
fun MediumCardPizza(
    state: HomeUiState,
    onSizeSelected: (TypeSize) -> Unit,
) {
    CardPizzaSize(
        text = "M",
        state = state,
        typeSize = TypeSize.Medium,
        onSizeSelected = { onSizeSelected(it) }
    )
}
