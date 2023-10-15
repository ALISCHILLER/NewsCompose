package com.msa.newscompose.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.msa.newscompose.domain.model.Article

class NewsPagingSource (
    private val newsApi:NewsApi,
    private val source:String
):PagingSource<Int,Article>(){
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        TODO("Not yet implemented")
    }
}