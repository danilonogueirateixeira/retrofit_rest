package br.com.retrofit_rest.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


@Dao
interface ProdutoDao {

    @Query("SELECT * FROM produto")
    fun all(): List<Produto>

    @Insert
    fun add(vararg produto: Produto)

}

