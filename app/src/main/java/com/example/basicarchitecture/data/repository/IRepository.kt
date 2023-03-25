package com.example.basicarchitecture.data.repository

import androidx.lifecycle.LiveData

interface IRepository<T> {
    suspend fun insert(o:T)
    suspend fun update(o:T)
    suspend fun delete(o:T)
    fun getAll(): LiveData<List<T>>
}