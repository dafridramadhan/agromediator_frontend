package com.example.agromediator_frontend.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agromediator_frontend.R
import com.example.agromediator_frontend.model.Routes

@Composable
fun DetailProduk(navController: NavController) {
    Scaffold(
        topBar = {
            androidx.compose.material.TopAppBar(
                backgroundColor = Color(0xFF80AF81),
                title = {
                    androidx.compose.material.Text("Deskripsi Produk")
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
                modifier = Modifier.statusBarsPadding()
            )
        },
        modifier = Modifier.fillMaxSize()
    ) {
            paddingValues ->  Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ){
        DeskripsiProduk()
        Spacer(modifier = Modifier.height(16.dp))
        CheckoutButton()
    }
    }
}

@Composable
fun DeskripsiProduk() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFE8F5E9), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pager_image),
            contentDescription = "Gambar Produk",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Deskripsi produk :", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(
            "Apel segar, manis dan renyah, kaya serat dan vitamin C. Ideal dinikmati langsung atau diolah menjadi jus dan salad.",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Harga : 20.000,00", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text("Total : 20.000,00", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text("Lokasi : ~~~~~ ~~~~ ~~~~", fontSize = 14.sp, color = Color.Gray)
    }
}
@Composable
fun CheckoutButton() {
    Button(
        onClick = { /* Handle checkout */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(48.dp),
        colors = ButtonDefaults.buttonColors( Color(0xFF4CAF50))
    ) {
        Text("Checkout", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
    }
}