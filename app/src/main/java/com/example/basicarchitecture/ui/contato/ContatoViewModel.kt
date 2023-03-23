package com.example.basicarchitecture.ui.contato

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContatoViewModel : ViewModel() {
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

    }

    fun reinitializeData() {
        _nome.value = ""
        _email.value = ""
    }


}