package com.msa.newscompose.data.manager


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.msa.newscompose.domain.manager.LocalUserManager
import com.msa.newscompose.util.Constants
import com.msa.newscompose.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class LocalUserManagerImpl(
    private val context:Context
):LocalUserManager{
    override suspend fun saveAppEnter() {
        context.dataStore.edit {settings ->
            settings[PreferenceKeys.APP_ENTRY]=true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
      return context.dataStore.data.map { preferences ->
          preferences[PreferenceKeys.APP_ENTRY]?:false
      }
    }


}


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private  object  PreferenceKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}