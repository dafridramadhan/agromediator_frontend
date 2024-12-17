package com.example.agromediator_frontend.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agromediator_frontend.R
import com.google.accompanist.pager.HorizontalPagerIndicator


@Composable
fun HomePage(paddingValues: PaddingValues) {
    val carouselState = rememberPagerState(initialPage = 0) { 3 }

    val images = listOf(
        R.drawable.pager_image,
        R.drawable.kebun,
        R.drawable.pager_image
    )

    val products = listOf(
        Product("Jeruk","Rp 16.000,00",R.drawable.jeruk),
        Product("Tomat","Rp 10.000,00",R.drawable.wortel),
        Product("Apel","Rp 20.000,00",R.drawable.apel),
        Product("Terong","Rp 25.000,00", R.drawable.terong_satu)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues),
    ) {
        // Search Bar
        SimpleSearchBar(
            query = "",
            onQueryChanged = {},
            onSearch = {}
        )

        // Carousel Section
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
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Kategori Section
        Text(
            "Kategori",
            fontSize = 20.sp,
            color = Color.Black
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            CategoryItem("Buah", R.drawable.apel)
            CategoryItem("Sayur", R.drawable.terong_satu)
        }

        Spacer(modifier = Modifier.height(15.dp))

        // Semua Produk Section
        Text(
            "Semua Produk",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(products.size) { index ->
                ProductItem(
                    product = products[index]
                )
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFDAF7D6)) // Warna hijau muda
            .padding(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // Gambar Produk
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            // Label Harga
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .background(Color(0x99000000)) // Warna hitam semi-transparan
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = product.price,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Nama Produk
        Text(
            text = product.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Lokasi Placeholder
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location",
                tint = Color.Gray,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "...... ...... ......",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
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
fun CategoryItem(name: String, imageRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { }
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(60.dp)
                .background(Color.LightGray, shape = CircleShape)
        )
        Text(text = name, fontSize = 15.sp, fontWeight = FontWeight.Medium)
    }
}
data class Product(
    val name: String,
    val price: String,
    val imageRes: Int
)