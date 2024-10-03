package com.vladdzyga.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vladdzyga.littlelemon.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = LittleLemonFontFamily.KarlaRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

object LittleLemonFontFamily {
    val KarlaRegular = FontFamily(Font(R.font.karla_regular))
    val MarkaziRegular = FontFamily(Font(R.font.markazi_text_regular))
}