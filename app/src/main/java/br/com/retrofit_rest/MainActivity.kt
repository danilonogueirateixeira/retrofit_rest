package br.com.retrofit_rest

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.retrofit_rest.model.Produto
import br.com.retrofit_rest.model.ProdutoDao
import br.com.retrofit_rest.network.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var produtoDao: ProdutoDao

    var produtos: List<Produto>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "tech-database")
            .allowMainThreadQueries()
            .build()
        produtoDao = database.produtoDao()



        val call = RetrofitInitializer().produtoService().list()



        call.enqueue(object : Callback<List<Produto>> {
            override fun onResponse(call: Call<List<Produto>>, response: Response<List<Produto>>) {

                response.body()?.let {
                    produtos = it



                    //Log.i("PRODUTOS", produtos.toString())
                }
                listar()

            }

            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                    Log.e("PRODUTOS", t.message)
            }

        })

    }

    fun listar(){
        for (i in 0 until produtos!!.size){

            Log.i("PRODUTOS", produtos!![i].nome + " "+ produtos!![i].marca)

            //produtoDao.add(produtos!![i])

        }

        var teste : List<Produto> = produtoDao.all()
        Log.i("PRODUTOS BANCO", teste[1].nome)
    }
}
