package com.example.sharebook.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CustomersAnswer(
    @SerializedName("kullanicilar")
    @Expose
    var kullanicilar:List<Customers>

) {

}