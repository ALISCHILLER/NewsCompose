package com.msa.newscompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.msa.newscompose.data.remote.NewsApi
import com.msa.newscompose.data.remote.NewsPagingSource
import com.msa.newscompose.domain.model.Article
import com.msa.newscompose.domain.repository.NewsRepositoryIn
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
):NewsRepositoryIn{
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi=newsApi,
                    sources= sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

}