package com.quotes.quotesapplication.presentation.screen



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quotes.quotesapplication.data.QuoteCategory
import com.quotes.quotesapplication.presentation.BannerSlider
import com.quotes.quotesapplication.presentation.components.QuotesCard
import com.quotes.quotesapplication.presentation.components.QuotesCategoryComponent
import com.quotes.quotesapplication.presentation.components.SectionHeader
import com.quotes.quotesapplication.ui.theme.Bold20
import com.quotes.quotesapplication.ui.theme.Normal14
import androidx.compose.foundation.lazy.items
import com.quotes.quotesapplication.QuotesApplication
import com.quotes.quotesapplication.data.Quote
import kotlinx.coroutines.channels.ticker


@Preview(showBackground = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier,onNavigateToExplore:(categoryId: String? , type: String?)-> Unit) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item {
            Text(
                text = "Explore",
                style = MaterialTheme.typography.Bold20.copy(fontSize = 24.sp),
                modifier= Modifier.padding(16.dp,16.dp,16.dp,0.dp)
            )

            Text(
                text = "Awesome Quotes from our community",
                style = MaterialTheme.typography.Normal14.copy(color = Color.Black.copy(alpha = .8f)),
                        modifier= Modifier.padding(16.dp,0.dp,16.dp,0.dp)

            )
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    //.height(200.dp)
                    //.padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                   // .clip(RoundedCornerShape(8.dp))

            ) {
                BannerSlider(Modifier.fillMaxSize(), Quote.getQuotes().filter { it.type=="Banner" })
            }
        }

        item {
            SectionHeader("Latest Quotes","View All", onNavigate = {
                  onNavigateToExplore(null,"Latest")
            })
        }

        item {

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.padding(top=16.dp)
            ) {

                items(Quote.getQuotes().filter { it.type=="Latest" }){ item->

                    QuotesCard(modifier,item, onSavedClick = {
                        if(item.isSaved){
                            item.isSaved= false
                            QuotesApplication.savedQuotes.remove(item)
                        }else{
                            item.isSaved= true
                            QuotesApplication.savedQuotes.add(item)
                        }

                    })

                }
            }
        }

        val categories = QuoteCategory.entries.toList()

        if (categories.isNotEmpty()) {

            item {
                SectionHeader("Categories ", "View All", onNavigate = {
                    onNavigateToExplore(null,null)
                })
            }

            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 12.dp)
                ) {

                    items(categories) { category ->

                        QuotesCategoryComponent(
                            title = category.displayName,
                            color = category.bgColor,
                            icon = category.icon,
                            onClick = {
                                selectedCategory->
                                onNavigateToExplore(selectedCategory,null)

                            }
                        )
                    }

                }
            }

        }
        item {
            SectionHeader("Trending Quotes","View All", onNavigate = {
                onNavigateToExplore(null, "Trending")
            })
        }

        item {

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.padding(top=16.dp)
            ) {

                items(Quote.getQuotes().filter { it.type=="Trending" }){ item->

                    QuotesCard(modifier,item, onSavedClick = {
                        if(item.isSaved){
                            item.isSaved= false
                            QuotesApplication.savedQuotes.remove(item)
                        }else{
                            item.isSaved= true
                            QuotesApplication.savedQuotes.add(item)
                        }
                    })

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun showUi() {
    HomeScreen(
        modifier = Modifier,
        onNavigateToExplore = { categoryId, type ->
            // Preview does nothing
        }
    )
}