package com.nqmgaming.news_mvvm.model

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)