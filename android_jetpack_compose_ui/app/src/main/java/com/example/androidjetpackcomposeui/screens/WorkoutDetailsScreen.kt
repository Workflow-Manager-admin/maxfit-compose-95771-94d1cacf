package com.example.androidjetpackcomposeui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.androidjetpackcomposeui.ui.theme.NeonAccent

private val exercises = listOf(
    ExerciseUi("Jumping Jacks", "00:30"),
    ExerciseUi("Plank", "01:00"),
    ExerciseUi("Burpees", "00:40"),
    ExerciseUi("Squats", "00:45")
)

data class ExerciseUi(val name: String, val duration: String)

// PUBLIC_INTERFACE
@Composable
fun WorkoutDetailsScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AsyncImage(
            model = "https://images.unsplash.com/photo-1464983953574-0892a716854b?auto=format&fit=crop&w=600&q=80",
            contentDescription = "Workout Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
                    )
                )
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Level Up: HIIT Burn",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = "Push your limits with this fat scorching HIIT workout. Let’s get fired up!",
                style = MaterialTheme.typography.bodyLarge,
                color = NeonAccent
            )
            Spacer(Modifier.height(24.dp))
            exercises.forEach { ex ->
                ExerciseRow(ex)
                Spacer(Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun ExerciseRow(ex: ExerciseUi) {
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(Color.White.copy(alpha = 0.18f))
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .size(44.dp)
                .background(NeonAccent, CircleShape)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.PlayArrow, contentDescription = "Play", tint = Color.Black)
        }
        Spacer(Modifier.width(16.dp))
        Text(
            ex.name,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
        Text(
            ex.duration,
            style = MaterialTheme.typography.labelLarge,
            color = NeonAccent
        )
    }
}
