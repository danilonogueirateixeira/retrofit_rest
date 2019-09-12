package br.com.retrofit_rest.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class Produto  (
                @PrimaryKey(autoGenerate = false)
                val id : String,
                val nome: String,
                val image: String,
                val descricao: String,
                val detalher: Boolean,
                val marca : String)