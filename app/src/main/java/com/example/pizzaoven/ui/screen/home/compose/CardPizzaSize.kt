package com.example.pizzaoven.ui.screen.home.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzaoven.ui.screen.home.viewModel.HomeUiState
import com.example.pizzaoven.ui.screen.home.viewModel.TypeSize

@Composable
fun CardPizzaSize(
    state: HomeUiState,
    text: String,
    modifier: Modifier = Modifier,
    typeSize: TypeSize,
    onSizeSelected: (TypeSize) -> Unit
) {

    Card(
        modifier = modifier
            .size(45.dp),
//            .background(Color.White, CircleShape),
        shape = CircleShape,
        colors = CardDefaults.cardColors(Color.Transparent),
//        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onSizeSelected(typeSize) },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun CardPizzaSize() {
    
}