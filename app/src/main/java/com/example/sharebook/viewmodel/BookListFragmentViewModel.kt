package com.example.sharebook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sharebook.entity.Books
import com.example.sharebook.repo.BooksDaoRepository

class BookListFragmentViewModel: ViewModel(){

    private val brepo = BooksDaoRepository()
    val booksList: MutableLiveData<List<Books>>

    init {
        loadBooks()
        booksList = brepo.bringBooks()
    }
    fun loadBooks(){
        brepo.getAllBooks("gulsahozaltun")
    }
    fun sepeteEkle(id:Int,sepet_durum:Int){
        brepo.sepetEkle(id,sepet_durum)
    }



}