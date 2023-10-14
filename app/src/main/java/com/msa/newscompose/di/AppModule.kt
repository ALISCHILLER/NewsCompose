package com.msa.newscompose.di

import android.app.Application
import com.msa.newscompose.data.manager.LocalUserManagerImpl
import com.msa.newscompose.domain.manager.LocalUserManager
import com.msa.newscompose.domain.usecases.AppEntryUseCases
import com.msa.newscompose.domain.usecases.ReadAppEntry
import com.msa.newscompose.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
    )=AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}