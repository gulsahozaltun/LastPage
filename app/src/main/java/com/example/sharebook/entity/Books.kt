package com.example.sharebook.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Books(
    @SerializedName("satici_adi")
    @Expose var satici_adi: String,
    @SerializedName("urun_adi")
    @Expose var urun_adi: String,
    @SerializedName("urun_fiyat")
    @Expose var urun_fiyat: String,
    @SerializedName("urun_aciklama")
    @Expose var urun_aciklama: String,
    @SerializedName("urun_gorsel_url")
    @Expose var urun_gorsel_url: String,
    @SerializedName("id")
    @Expose var id: String,
    @SerializedName("urun_indirimli_mi")
    @Expose var urun_indirimli_mi: String,
    @SerializedName("sepet_durum")
    @Expose var sepet_durum: Int


):Serializable {
}