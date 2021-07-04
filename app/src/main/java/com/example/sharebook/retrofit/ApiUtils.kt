package com.example.sharebook.retrofit

import com.example.sharebook.retrofit.RetrofitClient.Companion.getClient


class ApiUtils {

    companion object{
        //bu url ile kisilerDao daki url birlesip calisacak
        val BASE_URL:String="http://upschool.canerture.com/"

        fun getBooksDaoInterface(): BooksDaoInterface {
            return getClient(BASE_URL).create(BooksDaoInterface::class.java)
        }
        fun getCustomerDaoInterface(): CustomersDaoInterface {
            return getClient(BASE_URL).create(CustomersDaoInterface::class.java)
        }
    }


}