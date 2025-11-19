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
import com.quotes.quotesapplication.ui.theme.Bold14

import com.quotes.quotesapplication.ui.theme.Normal12

@Preview(showBackground = true)
@Composable
fun SavedScreen(){

    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.White)){

        item(){
            Text(text = "Explere", style = MaterialTheme.typography.Bold14)
        }

        items(count = 10){
            Card(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp)).padding(16.dp)) {

                Column (modifier = Modifier.fillMaxSize()){

                    Row (modifier = Modifier.fillMaxWidth()){

                        Text(text = "Explere", style = MaterialTheme.typography.Normal12, modifier = Modifier.padding(all = 16.dp))

                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = "Explere", style = MaterialTheme.typography.Normal12, modifier = Modifier.padding(all = 16.dp))

                    }

                    Text(text = "Explere", style = MaterialTheme.typography.Normal12, modifier = Modifier.padding(start = 16.dp))
                    Text(text = "Explere", style = MaterialTheme.typography.Normal12, modifier = Modifier.padding(start = 16.dp))


                }
            }
        }


    }

}