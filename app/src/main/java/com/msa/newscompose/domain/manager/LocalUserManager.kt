package com.msa.newscompose.domain.manager

import kotlinx.coroutines.flow.Flow


interface LocalUserManager {

    suspend fun saveAppEnter()

    fun readAppEntry(): Flow<Boolean>
}