package com.quotes.quotesapplication.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.dp
import com.quotes.quotesapplication.QuotesApplication
import com.quotes.quotesapplication.data.Quote
import com.quotes.quotesapplication.presentation.components.QuotesDetailCard
import com.quotes.quotesapplication.ui.theme.Bold14
import com.quotes.quotesapplication.ui.theme.Bold20

import com.quotes.quotesapplication.ui.theme.Normal12
import com.quotes.quotesapplication.ui.theme.Typography

@Preview(showBackground = true)
@Composable
fun SavedScreen(){
    val SavedList= QuotesApplication.savedQuotes.filter { it.isSaved }
    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White).padding(16.dp)){

        item {

            Text(style = Typography.Bold20,
                text = "Saved Quotes",
                modifier = Modifier.padding(16.dp))
        }

        items(SavedList){ item->

            QuotesDetailCard(item)

        }


    }

}