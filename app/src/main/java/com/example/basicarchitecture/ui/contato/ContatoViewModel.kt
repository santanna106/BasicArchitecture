package com.example.basicarchitecture.ui.contato

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicarchitecture.data.repository.ContatoRepository
import com.example.basicarchitecture.model.Contato
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
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

    fun salvar() {
        Log.d("TESTE","TESTE")

    }

    fun reinitializeData() {
        _nome.value = ""
        _email.value = ""
    }


}