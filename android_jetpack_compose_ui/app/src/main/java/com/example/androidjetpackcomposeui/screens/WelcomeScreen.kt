package com.example.androidjetpackcomposeui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.androidjetpackcomposeui.ui.theme.primaryGradientBrush

// PUBLIC_INTERFACE
@Composable
fun WelcomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryGradientBrush())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp, start = 24.dp, end = 24.dp, bottom = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Welcome to MaxFit!",
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "Crush your fitness goals with inspiring workouts and real results.",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Spacer(Modifier.height(24.dp))
            // Overlay Workout Cards
            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WorkoutCard(
                    imgUrl = "https://images.unsplash.com/photo-1517960413843-0aee8e2d471c?auto=format&fit=crop&w=400&q=80",
                    title = "HIIT Burn"
                )
                WorkoutCard(
                    imgUrl = "https://images.unsplash.com/photo-1518611012118-696072aa579a?auto=format&fit=crop&w=400&q=80",
                    title = "Strength"
                )
            }
            Spacer(Modifier.height(24.dp))
            Button(
                onClick = { navController.navigate("dashboard") },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .shadow(8.dp, RoundedCornerShape(50))
            ) {
                Text(text = "LET’S GET STARTED", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}

@Composable
fun WorkoutCard(imgUrl: String, title: String) {
    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier
            .width(140.dp)
            .height(180.dp)
            .shadow(10.dp, RoundedCornerShape(24.dp)),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Box(Modifier.fillMaxSize()) {
            AsyncImage(
                model = imgUrl,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                androidx.compose.ui.graphics.Color.Transparent,
                                androidx.compose.ui.graphics.Color(0xD0000000)
                            )
                        )
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text = title,
                    color = androidx.compose.ui.graphics.Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
