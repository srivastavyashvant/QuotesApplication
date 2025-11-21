package com.quotes.quotesapplication

import android.app.Application
import com.quotes.quotesapplication.data.Quote

class QuotesApplication: Application() {

    companion object {
        val savedQuotes = mutableListOf<Quote>()
    }
    override fun onCreate() {
        super.onCreate()


    }
}