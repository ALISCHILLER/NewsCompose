package com.msa.newscompose.domain.repository

import androidx.paging.PagingData
import com.msa.newscompose.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepositoryIn {

    fun getNews(sources:List<String>): Flow<PagingData<Article>>
}