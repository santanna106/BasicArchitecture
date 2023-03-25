package com.example.basicarchitecture.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.basicarchitecture.data.dao.ContatoDao
import com.example.basicarchitecture.model.Contato

@Database(
    entities = [Contato::class],
    version = 1
)
abstract class RoomDataBase : RoomDatabase() {
    abstract fun ContatoDao() : ContatoDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDataBase? = null

        fun getDatabase(context: Context) : RoomDataBase {
            val tempInstance = INSTANCE

            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDataBase::class.java,
                    "room_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}