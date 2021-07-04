package com.example.sharebook.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.sharebook.repo.BooksDaoRepository

class ShareBookFragmentViewModel:ViewModel() {
    var bdaor=BooksDaoRepository()

    fun kayit(satici_adi:String,urun_adi:String,urun_fiyat:String,urun_aciklama:String, urun_gorsel_url:String){
        bdaor.kitapEkle(satici_adi,urun_adi,urun_fiyat,urun_aciklama,urun_gorsel_url )
        Log.e("gelenler", satici_adi+urun_adi+urun_fiyat+urun_aciklama+urun_gorsel_url)
    }

    fun indirimYap(urun_id: String, urun_indirimli_mi: String){
        bdaor.indirimYap(urun_id,urun_indirimli_mi)

    }

}