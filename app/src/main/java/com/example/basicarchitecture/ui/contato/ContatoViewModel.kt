package com.example.basicarchitecture.ui.contato

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicarchitecture.data.repository.ContatoRepository
import com.example.basicarchitecture.model.Contato
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContatoViewModel @Inject constructor(
    private val repository: ContatoRepository
) : ViewModel() {
    private var _nome = MutableLiveData<String>()
    private var _email = MutableLiveData<String>()

    val nome: LiveData<String>
        get() = _nome

    val email: LiveData<String>
        get() = _email

    init {
        Log.d("GameFragment", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    suspend fun saveItem() {
        try{
            val contato = Contato(nome = _nome.value!!,email = _email.value!!)
            viewModelScope.launch (Dispatchers.IO){
                repository.insert(contato)
            }
        } catch (t:Throwable) {

        }
    }

    fun reinitializeData() {
        _nome.value = ""
        _email.value = ""
    }


}