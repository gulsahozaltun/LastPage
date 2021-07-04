package com.example.sharebook.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sharebook.entity.Books
import com.example.sharebook.entity.Customers
import com.example.sharebook.entity.CustomersAnswer
import com.example.sharebook.repo.CustomerDaoRepository
import com.example.sharebook.retrofit.ApiUtils
import com.example.sharebook.retrofit.CustomersDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInFragmentViewModel:ViewModel() {
    //private val cdaor=CustomerDaoRepository()
    private val cdaoi: CustomersDaoInterface
    //private val custList: MutableLiveData<List<Customers>>
    val kullaniciList:MutableLiveData<Customers>



    init {
        cdaoi = ApiUtils.getCustomerDaoInterface()
        kullaniciList= MutableLiveData()
        //custList=MutableLiveData()


    }

/*            fun girisYap(mail_adres:String,sifre:String){
                cdaor.girisYap(mail_adres,sifre)
            }*/
/*    fun loadCustomer():MutableLiveData<List<Customers>>{
        return  custList
    }*/

    fun girisYap(mail_adres: String,sifre: String){
        cdaoi.girisYap(mail_adres,sifre).enqueue(object : Callback<CustomersAnswer> {
            override fun onResponse(
                call: Call<CustomersAnswer>?,
                response: Response<CustomersAnswer>?

            ) {
                val customers= response!!.body().kullanicilar
                for (i in customers){
                    if(i.deger ==1){
                        kullaniciList.value=i
                    }
                    else{
                        kullaniciList.value = null}

                }

            }
            override fun onFailure(call: Call<CustomersAnswer>?, t: Throwable?) {

                Log.e("kullanici bulunamadi","no customer")
            }

        })
    }



}