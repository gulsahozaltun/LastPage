package com.example.sharebook.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.sharebook.repo.CustomerDaoRepository

class SignUpFragmentViewModel:ViewModel() {

    val cdaor=CustomerDaoRepository()
    fun kisiEkle(mail_adres: String, sifre: String, ad_soyad: String, telefon: String){
        cdaor.kisiKayit(mail_adres,sifre, ad_soyad, telefon)
        Log.e("gelenlerr", mail_adres+sifre+ad_soyad+telefon)
    }

}