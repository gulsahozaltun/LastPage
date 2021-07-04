package com.example.sharebook.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BooksAnswer(
    @SerializedName("urunler")
    @Expose var urunler:List<Books>,
    @SerializedName("success")
    @Expose var success:Int

) {
}