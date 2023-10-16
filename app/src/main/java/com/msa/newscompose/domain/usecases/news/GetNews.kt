package com.msa.newscompose.domain.usecases.news

import androidx.paging.PagingData
import com.msa.newscompose.domain.model.Article
import com.msa.newscompose.domain.repository.NewsRepositoryIn
import kotlinx.coroutines.flow.Flow


class GetNews(
    private val newsRepository :NewsRepositoryIn
) {
    operator fun invoke(sources:List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources=sources)
    }
}