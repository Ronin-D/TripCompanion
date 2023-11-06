package com.example.tripcompanion.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.tripcompanion.models.User
import com.example.tripcompanion.util.Constants
import com.example.tripcompanion.util.Constants.DATA_STORE_FILE_NAME
import kotlinx.coroutines.flow.*

class DataStoreRepository(private val context: Context) {
    private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(DATA_STORE_FILE_NAME)

    suspend fun setPref(prefKey:Preferences.Key<String>, value:String){
        context.dataStore.edit { settings->
            settings[prefKey] = value
        }
    }

    suspend fun getPref(prefKey:Preferences.Key<String>):Flow<String>{
        return  context.dataStore.data.map { settings->
            settings[prefKey]?:""
        }
    }

    companion object DataStoreKeys{
        val USER_LOGIN = stringPreferencesKey("user_login")
        val USER_PASSWORD = stringPreferencesKey("user_password")
    }

}