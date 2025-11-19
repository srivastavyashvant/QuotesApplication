package com.quotes.quotesapplication.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quotes.quotesapplication.data.QuoteCategory
import com.quotes.quotesapplication.presentation.components.SpacerWeight1f
import com.quotes.quotesapplication.ui.theme.Bold18
import com.quotes.quotesapplication.ui.theme.Normal12
import com.quotes.quotesapplication.ui.theme.Typography
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.quotes.quotesapplication.data.Quote
import com.quotes.quotesapplication.util.toCamelCase


@Preview
@Composable
fun ExploreScreen() {
    var selectedCategory by remember { mutableStateOf<String?>(null) }


    val categories = QuoteCategory.entries.toList()
    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White).padding(16.dp)) {


//        item {
//
//            Text(
//                text = "Life",
//                style = Typography.Bold18
//            )
//        }

        item {

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(categories) {item->
                    val isSelected = selectedCategory == item.name
                    Box(
                        modifier = Modifier
                            .background(if (isSelected) Color.Blue else Color.White, RoundedCornerShape(8.dp))
                            .border(1.dp, if (isSelected) Color.Blue else Color.Gray, RoundedCornerShape(8.dp))
                            .padding(vertical = 8.dp, horizontal = 8.dp).clickable {
                                selectedCategory = item.name   // Select item
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = item.name.toCamelCase(),
                            color = if (isSelected) Color.White else Color.Black,
                            style = Typography.bodyMedium
                        )
                    }
                }
            }
        }


        val filteredQuotes = Quote.getQuotes().filter { quote ->
            selectedCategory == null || quote.category.name == selectedCategory
        }

        items(filteredQuotes){ item->

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


    }

}