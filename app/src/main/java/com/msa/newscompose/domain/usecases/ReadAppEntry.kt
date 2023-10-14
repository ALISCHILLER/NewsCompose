package com.msa.newscompose.domain.usecases

import com.msa.newscompose.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke():Flow<Boolean>{
        return  localUserManager.readAppEntry()
    }
}