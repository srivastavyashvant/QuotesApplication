package com.quotes.quotesapplication.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card


import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.quotes.quotesapplication.data.Quote
import com.quotes.quotesapplication.data.QuoteCategory
import com.quotes.quotesapplication.ui.theme.Normal12


@Preview(showBackground = true)
@Composable()
fun QuotesCard(modifier: Modifier = Modifier, item: Quote,onSavedClick:(Int)-> Unit){

    Card(modifier = Modifier.width(200.dp).height(200.dp).clip(RoundedCornerShape(8.dp)),)
    {

        Column(modifier = Modifier.fillMaxSize().background(Color.Blue.copy(alpha = .5f)).padding(12.dp)) {

            Row(verticalAlignment = Alignment.CenterVertically){
                Surface(modifier.size(24.dp).clip(CircleShape),
                    color = Color.White.copy(alpha = .5f)){

                }

                   SpacerWeight1f()
                Icon(
                    Icons.Default.Share,
                    contentDescription = "ic_share",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)

                )

                Spacer(modifier.width(8.dp))
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "ic_share",
                    tint =if(item.isSaved) Color.Red else Color.White,
                    modifier = Modifier.size(24.dp).clickable { onSavedClick(item.id) }
                )


            }
            SpacerWeight1f()

            Text(
                item.text,
                style = MaterialTheme.typography.Normal12.copy(
                    color = Color.White,
                    lineHeight = 16.sp
                ),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                item.author,
                style = MaterialTheme.typography.Normal12.copy(
                    color = Color.White,
                    lineHeight = 16.sp,
                    fontStyle = FontStyle.Italic
                ),
                modifier = Modifier.padding(4.dp)
            )
        }

    }



}

@Preview(showBackground = true)
@Composable
fun showView(){
    QuotesCard(modifier= Modifier, Quote.getQuotes().get(0), onSavedClick ={})

}