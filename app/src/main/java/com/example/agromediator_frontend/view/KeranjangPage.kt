import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agromediator_frontend.R
import com.example.agromediator_frontend.model.Routes

@Composable
fun KeranjangPage(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Header
        HeaderSection(navController = navController)

        // Tab Bar
        TabSection()

        // Daftar Produk
        ProductList()
    }
}

@Composable
fun HeaderSection(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF4CAF50)) // Warna Hijau
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Back Button
        IconButton(onClick = { navController.navigate(Routes.Profile) }) {
            Icon(
                painter = painterResource(id = R.drawable.icons_back), // Ganti dengan ikon back arrow Anda
                contentDescription = "Back",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Keranjang",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun TabSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFDFF4D3))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TabItem("Belum Bayar", true)
        TabItem("Dikemas", false)
        TabItem("Dikirim", false)
        TabItem("Beri Penilaian", false)
    }
}

@Composable
fun TabItem(label: String, isSelected: Boolean) {
    Text(
        text = label,
        color = if (isSelected) Color.Black else Color.Gray,
        fontSize = 14.sp,
        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
    )
}

@Composable
fun ProductList() {
    Column(modifier = Modifier.padding(8.dp)) {
        ProductItem(imageRes = R.drawable.apel, description = "Apel Segar, Manis dan Renyah")
        ProductItem(imageRes = R.drawable.terong_satu, description = "Terong Ungu, Segar dan enak")
        ProductItem(imageRes = R.drawable.wortel, description = "Wortel, Sehat dan bergizi")
    }
}

@Composable
fun ProductItem(imageRes: Int, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Product Image",
            modifier = Modifier
                .size(60.dp)
                .padding(4.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = description,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
        }
    }
}