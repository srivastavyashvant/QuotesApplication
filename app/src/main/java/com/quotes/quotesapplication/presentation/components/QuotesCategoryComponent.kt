package com.quotes.quotesapplication.presentation.components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quotes.quotesapplication.ui.theme.Medium10
import com.quotes.quotesapplication.ui.theme.Typography

@Preview(showBackground = true)
@Composable
fun QuotesCategoryComponent(modifier: Modifier = Modifier,title:String= "Life",color:Color=Color.Red,   icon: ImageVector=Icons.Default.Favorite,onClick:(String)-> Unit) {

    Card(
        modifier = Modifier.width(80.dp).background(Color.Transparent)
            .clip(RoundedCornerShape(8.dp)).clickable {
                onClick(title)
            },
        colors = CardDefaults.cardColors(
            containerColor = color.copy(.1f) // 🔴 semi-transparent red background
        )) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Surface(
                modifier.size(40.dp).clip(CircleShape).background(Color.Transparent),
                color = color.copy(.3f)
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = "Feverit",
                    tint = color,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(8.dp),
                )

            }


            Spacer(modifier.height(8.dp))
            Text(
                text = title,
                style = Typography.Medium10.copy(color)
            )


        }
    }


}