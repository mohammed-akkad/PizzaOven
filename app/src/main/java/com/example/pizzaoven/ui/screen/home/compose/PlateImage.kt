package com.example.pizzaoven.ui.screen.home.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.pizzaoven.R
import com.example.pizzaoven.ui.screen.compose.CustomImage

@Composable
fun PlateImage(modifier: Modifier = Modifier) {
    CustomImage(
        painter = painterResource(id = R.drawable.plate),
        modifier = modifier
    )
}