package com.example.basicarchitecture.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contato_table")
data class Contato(
    @PrimaryKey(autoGenerate = true)
    val contatoId: Int? = null,
    @ColumnInfo(name = "nome")
    val nome: String,
    @ColumnInfo(name = "email")
    val email: String
    )

