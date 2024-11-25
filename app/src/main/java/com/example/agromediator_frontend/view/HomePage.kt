package com.example.agromediator_frontend.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.agromediator_frontend.R
import com.google.accompanist.pager.HorizontalPagerIndicator

@Composable
fun HomePage() {
    Scaffold (
        topBar = {
            TopAppBar (
                backgroundColor = Color(0xFFD6EFD8),
                title = {
                    Text("Beranda")
                },
                modifier = Modifier.statusBarsPadding()
            )
        },
        modifier = Modifier.fillMaxSize()
    ){
            paddingValues -> HomeContentScreen(paddingValues)
    }
}

@Composable
fun SimpleSearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearch: () -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = { onQueryChanged(it) },
        placeholder = { Text("Search...") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    )
}

@Composable
fun HomeContentScreen(paddingValues: PaddingValues) {
    val carouselState = rememberPagerState(initialPage = 0) {3}

    val images = listOf(
        R.drawable.pager_image,
        R.drawable.pager_image,
        R.drawable.pager_image
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD6EFD8))
            .padding(paddingValues),
    ) {
        SimpleSearchBar(
            query = "",
            onQueryChanged = {},
            onSearch = {}
        )
        HorizontalPager(
            state = carouselState,
            pageContent = {
                Image(
                    painter = painterResource(id = images[it]),
                    contentDescription = "Carousel Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                )
            }
        )
        HorizontalPagerIndicator(
            pagerState = carouselState,
            pageCount = images.size,
            activeColor = Color.Black,
            inactiveColor = Color.Gray,
            modifier = Modifier.padding(top = 8.dp).align(Alignment.CenterHorizontally)
        )
    }
}