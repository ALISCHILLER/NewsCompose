package com.msa.newscompose.domain.usecases.app_entry

import com.msa.newscompose.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManager.saveAppEnter()
    }

}