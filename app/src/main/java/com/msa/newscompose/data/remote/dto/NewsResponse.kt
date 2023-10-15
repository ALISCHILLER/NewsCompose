package com.msa.newscompose.data.remote.dto

import com.msa.newscompose.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)