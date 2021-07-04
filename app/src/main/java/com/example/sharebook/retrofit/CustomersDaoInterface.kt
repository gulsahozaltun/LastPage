package com.example.sharebook.retrofit

import com.example.sharebook.entity.BooksAnswer
import com.example.sharebook.entity.CRUDAnswer
import com.example.sharebook.entity.CustomersAnswer
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CustomersDaoInterface {


    @POST("uye_ol.php")
    @FormUrlEncoded
    fun kullaniciEkle(@Field("mail_adres") mail_adres:String,
                  @Field("sifre") sifre:String,
                  @Field("ad_soyad") ad_soyad:String,
                  @Field("telefon") telefon:String):Call<CRUDAnswer>

    @POST("giris_yap.php")
    @FormUrlEncoded
    fun girisYap(@Field("mail_adres") mail_adres: String,
                 @Field("sifre")sifre: String):Call<CustomersAnswer>

}