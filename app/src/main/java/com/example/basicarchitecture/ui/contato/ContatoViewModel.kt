package com.example.basicarchitecture.ui.contato

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
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

    val _nome = MutableLiveData<String>()
    var _email = MutableLiveData<String>()

    val nome: LiveData<String>
        get() = _nome

    val email: LiveData<String>
        get() = _email

    init {
        Log.d("BasicArchitecture", "BasicArchitecture created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("BasicArchitecture", "BasicArchitecture destroyed!")
    }

    fun setNome(pNome: String) {
        _nome.value = pNome
    }


    fun salvar() {
        Log.d("nome",nome.value.toString())
        Log.d("email",email.value.toString())
        val contato = Contato(null,nome.value.toString(),email.value.toString())
        viewModelScope.launch (Dispatchers.IO){
            repository.insert(contato)
        }
    }

    fun reinitializeData() {
        _nome.value = ""
        _email.value = ""
    }


}