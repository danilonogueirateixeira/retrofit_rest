package br.com.retrofit_rest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://economizamais.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun produtoService() = retrofit.create(ProdutosService::class.java)
}