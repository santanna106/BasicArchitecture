package com.example.basicarchitecture.data.repository

import androidx.lifecycle.LiveData
import com.example.basicarchitecture.data.dao.ContatoDao
import com.example.basicarchitecture.model.Contato
import javax.inject.Inject

class ContatoRepository @Inject constructor(private val contatoDao: ContatoDao)  : IRepository<Contato> {
    override suspend fun insert(o: Contato)  = contatoDao.insert(o)
    override suspend fun update(o: Contato) = contatoDao.updateContato(o)
    override suspend fun delete(o: Contato) = contatoDao.delete(o)

    override fun getAll(): LiveData<List<Contato>> = contatoDao.getContatos()

}