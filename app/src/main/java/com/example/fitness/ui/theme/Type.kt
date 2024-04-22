package com.example.fitness.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fitness.R

val AbrilFatface = FontFamily(
    Font(R.font.abril_fatface_regular)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displaySmall = TextStyle(
        fontSize = 20.sp
    ),
    displayMedium = TextStyle(
        fontSize = 20.sp
    ),
    displayLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        fontFamily = AbrilFatface,)

)