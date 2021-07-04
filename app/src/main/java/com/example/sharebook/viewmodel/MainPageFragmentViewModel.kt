package com.example.sharebook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sharebook.entity.Books
import com.example.sharebook.repo.BooksDaoRepository
import java.math.RoundingMode
import java.text.DecimalFormat

class MainPageFragmentViewModel:ViewModel() {
    private val brepo = BooksDaoRepository()
    val booksList:MutableLiveData<List<Books>>
    //var priceResult = MutableLiveData<String>()

    init {
        loadBooks()
        booksList = brepo.bringBooks()
        //priceResult = MutableLiveData<String>("0")
        //priceResult=bringPrice()
    }

    fun loadBooks(){
        brepo.getAllBooks("gulsahozaltun")}


    fun sepeteEkle(id:Int,sepet_durum:Int){
        brepo.sepetEkle(id,sepet_durum)
    }

    fun sepettenCikar(id:Int,sepet_durum:Int){
        brepo.sepettenCikar(id,sepet_durum)

    }


/*       fun getSmallSizePrice(price:String){

        val dpPrice= price.toDouble()
           var stPrice:String
           val sonuc:Double
           sonuc=dpPrice.minus(5.0)
           val df = DecimalFormat("##.##")
           df.roundingMode = RoundingMode.CEILING
           stPrice = df.format(sonuc)
        priceResult.value = stPrice

    }

    fun bringPrice():MutableLiveData<String>{
        return priceResult

    }*/

}