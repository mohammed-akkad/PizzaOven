package com.example.pizzaoven.ui.screen.home.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pizzaoven.ui.screen.home.viewModel.HomeUiState
import com.example.pizzaoven.ui.screen.home.viewModel.TypeSize

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun PizzaPager(
    modifier: Modifier = Modifier,
    state: HomeUiState,
    onBreadSelected: (Int) -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = state.selectedBreadIndex,
        pageCount = { state.breads.size }
    )
    HorizontalPager(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
        state = pagerState,

    ) { index ->
        val transition =
            updateTransition(targetState = state.selectedSizePizza, label = "size")
        val size by transition.animateDp(label = "size") {
            when (it) {
                TypeSize.Small -> 165.dp
                TypeSize.Medium -> 190.dp
                TypeSize.Large -> 230.dp
            }
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(state.breads[index])
                    .build(), contentDescription = null,
                modifier = Modifier.width(size)
            )
            state.ingredientUiState.forEach {ingredient ->
                AnimatedVisibility(
                    visible = ingredient.isSelected,
                    enter = scaleIn(initialScale = 15f),
                    exit = fadeOut()
                ) {

                    Ingredients(items = ingredient, size = size / 6)
                }
            }
        }
    }
    LaunchedEffect(pagerState.currentPage) {
        onBreadSelected(pagerState.currentPage)
    }

}