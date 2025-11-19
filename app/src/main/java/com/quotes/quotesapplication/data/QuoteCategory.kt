package com.quotes.quotesapplication.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

enum class QuoteCategory(val displayName: String, val icon: ImageVector, val bgColor: Color) {
    LIFE("Life", Icons.Filled.Favorite, bgColor = Color.Red),
    MOTIVATION("Motivation", Icons.Filled.Star, bgColor = Color.Green),
    SUCCESS("Success", Icons.AutoMirrored.Filled.Send, bgColor = Color.Yellow),
    WISDOM("Wisdom", Icons.Filled.Info, bgColor = Color.Cyan),
    LOVE("Love", Icons.Filled.FavoriteBorder, bgColor = Color.Magenta),
    COURAGE("Courage", Icons.Filled.Share, bgColor = Color.Gray),
    LEADERSHIP("Leadership", Icons.Filled.AccountCircle, bgColor = Color.Red);


    companion object {
        fun getCategory(name: String?):QuoteCategory? {
            return QuoteCategory.entries.firstOrNull {
                it.name.equals(name, ignoreCase = true)
            }
        }
    }
}