package com.msa.newscompose.di

import android.app.Application
import com.msa.newscompose.data.manager.LocalUserManagerImpl
import com.msa.newscompose.data.remote.NewsApi
import com.msa.newscompose.data.repository.NewsRepositoryImpl
import com.msa.newscompose.domain.manager.LocalUserManager
import com.msa.newscompose.domain.repository.NewsRepositoryIn
import com.msa.newscompose.domain.usecases.app_entry.AppEntryUseCases
import com.msa.newscompose.domain.usecases.app_entry.ReadAppEntry
import com.msa.newscompose.domain.usecases.app_entry.SaveAppEntry
import com.msa.newscompose.domain.usecases.news.GetNews
import com.msa.newscompose.domain.usecases.news.NewsUseCases
import com.msa.newscompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ):LocalUserManager=LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    )= AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }
    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ):NewsRepositoryIn = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepositoryIn: NewsRepositoryIn
    ):NewsUseCases{
        return  NewsUseCases(
            getNews = GetNews(newsRepositoryIn)
        )
    }

}