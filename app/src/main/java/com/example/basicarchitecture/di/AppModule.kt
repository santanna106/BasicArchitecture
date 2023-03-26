package com.example.basicarchitecture.di

import android.app.Application
import android.content.Context
import com.example.basicarchitecture.data.RoomDataBase
import com.example.basicarchitecture.data.dao.ContatoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun getAppDataBase(context: Application):RoomDataBase{
        return RoomDataBase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun getAppDao(appDatabase: RoomDataBase): ContatoDao {
        return appDatabase.ContatoDao()
    }


}