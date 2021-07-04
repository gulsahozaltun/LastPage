package com.example.sharebook.retrofit

import com.example.sharebook.entity.BooksAnswer
import com.example.sharebook.entity.CRUDAnswer
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface BooksDaoInterface {
    @GET("urunler/urunler.php")
    fun tumKitaplar(): Call<BooksAnswer>

    @POST("urunler.php")
    @FormUrlEncoded
    fun getAllItems(@Field("satici_adi") satici_adi: String): Call<BooksAnswer>


/*
    //indirimli urun
    @POST("urunler.php")
    @FormUrlEncoded
    fun getDiscountItems(
        @Field("urun_indirimli_mi")urun_indirimli_mi:String,
        @Field("satici_adi") satici_adi: String): Call<BooksAnswer>
*/




    @POST("indirimli_urun_durum_degistir.php")
    @FormUrlEncoded
    fun indirimYap(
        @Field("id")id:String,
        @Field("urun_indirimli_mi")urun_indirimli_mi:String) : Call<BooksAnswer>





    @POST("urun_ekle.php")
    @FormUrlEncoded
    fun kitapEkle(@Field("satici_adi") satici_adi:String,
                  @Field("urun_adi") urun_adi:String,
                  @Field("urun_fiyat") urun_fiyat:String,
                  @Field("urun_aciklama") urun_aciklama:String,
                  @Field("urun_gorsel_url") urun_gorsel_url:String):Call<CRUDAnswer>

    @POST("sepet_durum_degistir.php")
    @FormUrlEncoded
    fun sepetDurum(
        @Field("id") id: Int,
        @Field("sepet_durum") sepet_durum:Int) :Call<BooksAnswer>




}