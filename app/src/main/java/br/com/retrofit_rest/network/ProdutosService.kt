package br.com.retrofit_rest.network

import br.com.retrofit_rest.model.Produto
import retrofit2.Call
import retrofit2.http.GET

interface ProdutosService{

    @GET("produtos/")
    fun list() : Call <List<Produto>>
}