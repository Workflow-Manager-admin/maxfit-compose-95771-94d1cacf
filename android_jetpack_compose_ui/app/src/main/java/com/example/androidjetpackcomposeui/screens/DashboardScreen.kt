package com.example.androidjetpackcomposeui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.androidjetpackcomposeui.ui.theme.*

private val workoutList = listOf(
    WorkoutUi("https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=400&q=80", "Full Body", "45 min"),
    WorkoutUi("https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=400&q=80", "Yoga", "30 min"),
    WorkoutUi("https://images.unsplash.com/photo-1445384763658-0400939829cd?auto=format&fit=crop&w=400&q=80", "Cardio", "25 min"),
    WorkoutUi("https://images.unsplash.com/photo-1517960413843-0aee8e2d471c?auto=format&fit=crop&w=400&q=80", "HIIT", "20 min")
)

private val categories = listOf("Stretching", "Upper Body", "Lower Body", "Core")

data class WorkoutUi(val imgUrl: String, val title: String, val time: String)

// PUBLIC_INTERFACE
@Composable
fun DashboardScreen(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf(0) }

    Box(
        Modifier
            .fillMaxSize()
            .background(primaryGradientBrush())
    ) {
        Column(Modifier.fillMaxSize()) {
            // App Bar
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp, vertical = 22.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = NeonAccent)
                Spacer(Modifier.weight(1f))
                Text(
                    "MaxFit",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(Modifier.weight(1f))
                Icon(Icons.Default.Settings, contentDescription = "Settings", tint = NeonAccent)
            }
            // Program Header
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.28f)),
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier
                    .padding(horizontal = 18.dp)
                    .fillMaxWidth()
                    .height(110.dp)
                    .shadow(8.dp, RoundedCornerShape(24.dp))
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Current Program",
                        color = NeonAccent,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        "Ultimate Shred Challenge",
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        "7 days left",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Spacer(Modifier.height(14.dp))
            // Tabs
            TabRow(selectedTabIndex = selectedTab,
                containerColor = Color.Transparent,
                contentColor = NeonAccent,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                categories.forEachIndexed { i, title ->
                    Tab(
                        selected = selectedTab == i,
                        onClick = { selectedTab = i },
                        selectedContentColor = NeonAccent,
                        unselectedContentColor = MaterialTheme.colorScheme.onSurface
                    ) {
                        Text(
                            title,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
                        )
                    }
                }
            }
            // Horizontal Workout Carousel
            LazyRow(
                Modifier
                    .padding(vertical = 18.dp)
                    .fillMaxWidth()
            ) {
                items(workoutList.size) { idx ->
                    val workout = workoutList[idx]
                    WorkoutCarouselCard(workout)
                }
            }
            // Week Progress / Timeline Section
            Text(
                text = "This Week's Progress",
                color = NeonAccent,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(horizontal = 22.dp, vertical = 10.dp)
            )
            Row(
                Modifier
                    .padding(horizontal = 22.dp, vertical = 4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(7) { i ->
                    Box(
                        Modifier
                            .size(22.dp)
                            .background(
                                if (i < 3) NeonAccent else Color.White.copy(alpha = 0.2f),
                                shape = CircleShape
                            )
                            .shadow(if (i < 3) 6.dp else 0.dp, shape = CircleShape)
                    )
                }
            }
            Spacer(Modifier.weight(1f))
            // Bottom Navigation
            BottomNavBar()
        }
    }
}

@Composable
fun WorkoutCarouselCard(workout: WorkoutUi) {
    Card(
        shape = RoundedCornerShape(28.dp),
        modifier = Modifier
            .width(170.dp)
            .height(200.dp)
            .padding(horizontal = 8.dp)
            .shadow(10.dp, RoundedCornerShape(28.dp)),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(Modifier.fillMaxSize()) {
            AsyncImage(
                model = workout.imgUrl,
                contentDescription = workout.title,
                contentScale = androidx.compose.ui.layout.ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
                        )
                    )
                    .padding(10.dp)
            ) {
                Column {
                    Text(
                        workout.title,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        workout.time,
                        color = NeonAccent,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavBar() {
    NavigationBar(
        containerColor = Color.White.copy(alpha = 0.85f),
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .shadow(6.dp, RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
    ) {
        NavigationBarItem(
            selected = true, onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painterResource(android.R.drawable.ic_menu_view),
                    contentDescription = "Home",
                    tint = NeonAccent
                )
            },
            label = { Text("Home") })
        NavigationBarItem(
            selected = false, onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painterResource(android.R.drawable.ic_menu_search),
                    contentDescription = "Explore",
                    tint = NeonAccent
                )
            },
            label = { Text("Explore") })
        NavigationBarItem(
            selected = false, onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painterResource(android.R.drawable.ic_menu_myplaces),
                    contentDescription = "Profile",
                    tint = NeonAccent
                )
            },
            label = { Text("Profile") })
    }
}
