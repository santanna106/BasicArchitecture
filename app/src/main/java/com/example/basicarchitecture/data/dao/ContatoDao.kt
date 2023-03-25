package com.example.basicarchitecture.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.basicarchitecture.model.Contato

@Dao
interface ContatoDao {

    @Query("SELECT * FROM contato_table ORDER BY nome ASC")
    fun getContatos(): LiveData<List<Contato>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contato: Contato)

    @Update
    suspend fun updateContato(contato: Contato)

    @Query("DELETE FROM contato_table")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(contato: Contato)
}