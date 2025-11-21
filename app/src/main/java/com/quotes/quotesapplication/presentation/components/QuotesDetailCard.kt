package com.quotes.quotesapplication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quotes.quotesapplication.data.Quote
import com.quotes.quotesapplication.presentation.components.SpacerWeight1f
import com.quotes.quotesapplication.ui.theme.Normal12
import com.quotes.quotesapplication.ui.theme.Typography

@Preview(showBackground = true)
@Composable
fun QuotesDetailCard(item: Quote){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .padding(top = 16.dp, start = 4.dp, end = 4.dp, bottom = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White // proper background
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White
                ).padding(12.dp),
        ) {

            Row {

                Surface (modifier = Modifier.size(32.dp).clip(CircleShape).background(Color.Blue)){
                    Icon( imageVector = Icons.Default.ThumbUp,
                        contentDescription = "",
                        modifier = Modifier.padding(8.dp),
                        tint = Color.Blue)
                }


                SpacerWeight1f()
                Text(
                    text = item.category.displayName,
                    color = Color.Black,
                    style = Typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = item.text,
                color = Color.Black,
                style = Typography.bodyMedium
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Text(
                text = item.author,
                color = Color.Black,
                style = Typography.Normal12,
                fontStyle = FontStyle.Italic
            )

        }
    }

}