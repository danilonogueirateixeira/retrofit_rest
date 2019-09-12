package br.com.retrofit_rest

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.retrofit_rest.model.Produto
import br.com.retrofit_rest.model.ProdutoDao

@Database(entities = [Produto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun produtoDao(): ProdutoDao

}