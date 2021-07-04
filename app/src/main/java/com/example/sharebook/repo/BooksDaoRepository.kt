package com.example.sharebook.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sharebook.entity.Books
import com.example.sharebook.entity.BooksAnswer
import com.example.sharebook.entity.CRUDAnswer
import com.example.sharebook.retrofit.ApiUtils
import com.example.sharebook.retrofit.BooksDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksDaoRepository {
    private val bdaoi: BooksDaoInterface
    private val bookList: MutableLiveData<List<Books>>



    init{
        bdaoi= ApiUtils.getBooksDaoInterface()
        bookList = MutableLiveData()


    }

    fun bringBooks():MutableLiveData<List<Books>>{
        return bookList
    }



    fun getAllBooks(satici_adi: String){
        bdaoi.getAllItems("gulsahozaltun").enqueue(object : Callback<BooksAnswer> {
            override fun onResponse(call: Call<BooksAnswer>?, response: Response<BooksAnswer>) {
                val list: List<Books> = response.body().urunler
                bookList.value = list


            }
                override fun onFailure(call: Call<BooksAnswer>?, t: Throwable?) {
                    Log.e("Error", "failed")
                }
            })
        }


    fun kitapEkle(satici_adi:String,urun_adi:String,urun_fiyat:String,urun_aciklama:String, urun_gorsel_url:String){
        bdaoi.kitapEkle(satici_adi,urun_adi,urun_fiyat,urun_aciklama,urun_gorsel_url).enqueue(object: Callback<CRUDAnswer> {
            override fun onResponse(call: Call<CRUDAnswer>?, response: Response<CRUDAnswer>) {
                Log.e("success", response.body().toString())
                Log.e("basarili","mission complete")
            }

            override fun onFailure(call: Call<CRUDAnswer>?, t: Throwable?) {
                Log.e("faiill",t.toString()!!)
            }
        })
    }

    fun indirimYap(id: String, urun_indirimli_mi: String){
        bdaoi.indirimYap(id,urun_indirimli_mi).enqueue(object: Callback<BooksAnswer> {
            override fun onResponse(call: Call<BooksAnswer>?, response: Response<BooksAnswer>?) {
               Log.e("yeni durummm", id.toString()+ "  "+ urun_indirimli_mi.toString())


            }

            override fun onFailure(call: Call<BooksAnswer>?, t: Throwable?) {
                Log.e("nooooo","nolamazzzzzz")
            }

        })
    }



    fun sepetEkle(id: Int,sepet_durum:Int){
        bdaoi.sepetDurum(id, sepet_durum).enqueue(object :Callback<BooksAnswer>{
            override fun onResponse(call: Call<BooksAnswer>?, response: Response<BooksAnswer>?) {
                Log.e("yeni durummm", id.toString()+ "  "+ sepet_durum.toString())


            }

            override fun onFailure(call: Call<BooksAnswer>?, t: Throwable?) {
                Log.e("fail  maalesef","no way ")
            }


        })
    }
    fun sepettenCikar(id: Int,sepet_durum:Int){
        bdaoi.sepetDurum(id, sepet_durum).enqueue(object :Callback<BooksAnswer>{
            override fun onResponse(call: Call<BooksAnswer>?, response: Response<BooksAnswer>?) {
                Log.e("yeni durummm", id.toString()+ "  "+ sepet_durum.toString())


            }


            override fun onFailure(call: Call<BooksAnswer>?, t: Throwable?) {
                Log.e("fail  maalesef","no way ")
            }


        })
    }









}
