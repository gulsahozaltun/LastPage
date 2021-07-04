package com.example.sharebook.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sharebook.entity.CRUDAnswer
import com.example.sharebook.entity.Customers
import com.example.sharebook.entity.CustomersAnswer
import com.example.sharebook.retrofit.ApiUtils
import com.example.sharebook.retrofit.CustomersDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CustomerDaoRepository {
    private val cdaoi: CustomersDaoInterface
    val kullaniciList:MutableLiveData<Customers>

    init {
        cdaoi = ApiUtils.getCustomerDaoInterface()
        kullaniciList= MutableLiveData()

    }

    fun kisiKayit(mail_adres: String, sifre: String, ad_soyad: String, telefon: String) {
        cdaoi.kullaniciEkle(mail_adres, sifre, ad_soyad, telefon)
            .enqueue(object : Callback<CRUDAnswer> {
                override fun onResponse(
                    call: Call<CRUDAnswer>?,
                    response: Response<CRUDAnswer>){
                    Log.e("se=uccsadsdafa",response.body().toString())
                    Log.e("basariliii","Adadadafzhjhgfds")


            }

                override fun onFailure(call: Call<CRUDAnswer>?, t: Throwable?) {
                    Log.e("fail",t.toString()!!)

                }
            })
}



}
