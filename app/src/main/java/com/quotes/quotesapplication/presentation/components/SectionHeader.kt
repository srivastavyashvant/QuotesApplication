package com.quotes.quotesapplication.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quotes.quotesapplication.ui.theme.Bold14
import com.quotes.quotesapplication.ui.theme.Typography

@Composable
fun SectionHeader(startText: String,endText:String,onNavigate:()-> Unit){
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp,32.dp,16.dp,0.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {

        Text(text = startText,
            style = Typography.Bold14
        )

        Text(text = endText,
            style = Typography.Bold14,
            modifier = Modifier.clickable { onNavigate() }
        )
    }
}