package com.example.agromediator_frontend.view

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agromediator_frontend.R
import com.example.agromediator_frontend.model.Routes

@Composable
fun TroliPage(navController: NavController) {
    Scaffold(
        topBar = {
            androidx.compose.material.TopAppBar(
                backgroundColor = Color(0xFF80AF81),
                title = {
                    androidx.compose.material.Text("Transaksi")
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
            paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            AlamatPengiriman()
            Spacer(modifier = Modifier.height(8.dp))
            DetailProduk()
            Spacer(modifier = Modifier.height(16.dp))
            MetodePembayaran()
        }
    }
}

@Composable
fun AlamatPengiriman() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F0F0))
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.icons_location),
                contentDescription = "Alamat",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Alamat pengiriman", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Jl. Mawar No. 123, Jakarta Selatan",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun DetailProduk() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFE8F5E9), shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)) // Hijau muda
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.kebun),
            contentDescription = "Gambar Produk",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Apel", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            "Deskripsi produk: Apel segar, manis dan renyah, kaya serat dan vitamin C. Ideal dinikmati langsung atau diolah menjadi jus dan salad.",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Harga: Rp 20.000,00", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Composable
fun MetodePembayaran() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            "Metode Pembayaran",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MetodePembayaranItem(label = "BANK", iconRes = R.drawable.icons_bank)
            MetodePembayaranItem(label = "DANA", iconRes = R.drawable.dana_icons)
            MetodePembayaranItem(label = "E-Wallet", iconRes = R.drawable.ewallet_icons)
            MetodePembayaranItem(label = "COD", iconRes = R.drawable.icons_cod)
        }
    }
}

@Composable
fun MetodePembayaranItem(label: String, iconRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {  }
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, fontSize = 12.sp, textAlign = TextAlign.Center)
    }
}
