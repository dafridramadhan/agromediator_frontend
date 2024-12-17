package com.example.agromediator_frontend.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agromediator_frontend.R
import com.example.agromediator_frontend.model.Routes

@Composable
fun ProfilePage(navController: NavController) {

    Scaffold (
        topBar = {
            TopAppBar (
                backgroundColor = Color(0xFF80AF81),
                title = {
                    Text("Profile Page")
                },
                navigationIcon = {

                    androidx.compose.material.IconButton(onClick = {
                        navController.navigate(Routes.home)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icons_back), // Ganti dengan ikon back arrow Anda
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    androidx.compose.material.IconButton(onClick = {
                        navController.navigate(Routes.cart) // Navigate to cart screen
                    }) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Cart",
                            tint = Color.White
                        )
                    }
                },
                modifier = Modifier.statusBarsPadding()
            )
        },

        modifier = Modifier.fillMaxSize()

    ){
            paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ProfileContentScreen(paddingValues,navController)
            Spacer(modifier = Modifier.height(16.dp))
            OrderStatusSection()
            Spacer(modifier = Modifier.height(16.dp))
            PurchaseHistory()
        }
    }
}

@Composable
fun ProfileContentScreen(paddingValues: PaddingValues,navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE8F5E9)) // Light green background
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_agroculture), // Replace with your drawable
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text("Ali Trisono", fontWeight = FontWeight.Bold, fontSize = 30.sp)
            Spacer(modifier = Modifier.height(3.dp))
            TextButton(onClick = {navController.navigate(Routes.Editprofile)}) {
            Text("Edit Profile", color = Color(0xFF4CAF50)) // Green text
        }
    }
}

@Composable
fun OrderStatusSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OrderStatusItem("Belum Bayar", R.drawable.register_icon)
        OrderStatusItem("Dikemas", R.drawable.register_icon)
        OrderStatusItem("Dikirim", R.drawable.register_icon)
        OrderStatusItem("Beri Penilaian", R.drawable.register_icon)
    }
}

@Composable
fun OrderStatusItem(label: String, iconRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { /* Handle click */ }
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = Color(0xFF4CAF50) // Green icon
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, fontSize = 12.sp, textAlign = TextAlign.Center)
    }
}
@Composable
fun PurchaseHistory() {
    Column {
        Text("Riwayat Pembelian", fontWeight = FontWeight.Bold, fontSize = 18.sp, style = TextStyle())
        Spacer(modifier = Modifier.height(8.dp))
        repeat(4) { // Example for 3 items
            PurchaseHistoryItem(
                imageRes = R.drawable.kebun, // Replace with your drawable
                description = "Deskripsi produk"
            )
        }
    }
}

@Composable
fun PurchaseHistoryItem(imageRes: Int, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Product Image",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = description,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
        )
    }
}