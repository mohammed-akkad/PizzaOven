package com.example.pizzaoven.ui.screen.home

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaoven.ui.screen.home.compose.ItemPizzaIcon
import com.example.pizzaoven.ui.screen.home.compose.LargeCardPizza
import com.example.pizzaoven.ui.screen.home.compose.MediumCardPizza
import com.example.pizzaoven.ui.screen.home.compose.PizzaPager
import com.example.pizzaoven.ui.screen.home.compose.PlateImage
import com.example.pizzaoven.ui.screen.home.compose.SmallCardPizza
import com.example.pizzaoven.ui.screen.home.viewModel.HomeUiState
import com.example.pizzaoven.ui.screen.home.viewModel.HomeViewModel
import com.example.pizzaoven.ui.screen.home.viewModel.IngredientUiState
import com.example.pizzaoven.ui.screen.home.viewModel.TypeSize
import com.project.pizzaorderapp.ui.theme.DarkGray
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(
        state,
        onSizeSelected = viewModel::selectedSize,
        onClickIngredient = viewModel::isSelectedIngredient,
        onBreadSelected = viewModel::selectedBread
    )
}

@Composable
fun HomeContent(
    state: HomeUiState,
    onSizeSelected: (TypeSize) -> Unit,
    onClickIngredient: (IngredientUiState) -> Unit,
    onBreadSelected: (Int) -> Unit
) {

    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.height(400.dp)) {
                PlateImage(
                    modifier = Modifier
                        .width(275.dp)
                        .padding(top = 80.dp)
                )
                PizzaPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 80.dp)
                        .wrapContentHeight(), state,
                    onBreadSelected = onBreadSelected
                )
            }
        }


        item{
            Text(
                text = "$17", modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 24.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
        }

        item{
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    8.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                val transition = updateTransition(targetState = state.selectedSizePizza, label = "")
                val elevation by transition.animateDp(
                    label = "",
                    transitionSpec = { tween(durationMillis = 250) }
                ) {
                    when (it) {
                        TypeSize.Small -> 53.dp
                        TypeSize.Medium -> 105.dp
                        TypeSize.Large -> 158.dp
                    }
                }

                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .offset(x = elevation)
                        .shadow(8.dp, CircleShape)
                        .background(Color.White)
                )
                SmallCardPizza(state, onSizeSelected)
                MediumCardPizza(state, onSizeSelected)
                LargeCardPizza(state, onSizeSelected)
            }
        }


        item{
            Text(
                text = "CUSTOMIZE YOUR PIZZA",
                color = Color.Black.copy(alpha = 0.38f),
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 16.dp, top = 32.dp)
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 64.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    16.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                items(items = state.ingredientUiState) {
                    ItemPizzaIcon(onClickIngredient = onClickIngredient, it)
                }
            }
        }

        item {
            Button(
                onClick = { }, modifier = Modifier
                    .wrapContentWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(DarkGray),
                contentPadding = PaddingValues(horizontal = 24.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "Add to cart",
                    color = Color.White.copy(alpha = 0.87f),
                    fontSize = 16.sp
                )
            }
        }



    }
}

@Preview(showSystemUi = true)
@Composable
fun MyPreview() {
//    Ingredients(items = basil, size = 165.dp)
}
