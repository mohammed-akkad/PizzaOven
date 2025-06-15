package com.example.pizzaoven.ui.screen.home.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pizzaoven.ui.screen.home.viewModel.IngredientUiState

@Composable
fun Ingredients(items: IngredientUiState, size: Dp) {

    FlowRow(
        maxItemsInEachRow = 3,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        items.ingredients.forEach {
            val randomOffsetX = (10).dp
            val randomOffsetY = (11).dp

            Image(
                modifier = Modifier
                    .width(size)
                    .clip(CircleShape)
                    .offset(x = randomOffsetX, y = randomOffsetY),
                painter = painterResource(id = it),
                contentDescription = null,
                contentScale = ContentScale.Inside
            )
        }

    }
}