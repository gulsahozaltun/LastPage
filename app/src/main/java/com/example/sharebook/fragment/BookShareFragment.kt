package com.example.sharebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.sharebook.R
import com.example.sharebook.databinding.FragmentBookShareBinding
import com.example.sharebook.viewmodel.ShareBookFragmentViewModel


class BookShareFragment : Fragment() {
    private lateinit var tasarim:FragmentBookShareBinding
     private lateinit var viewModel: ShareBookFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_book_share, container, false)
        tasarim.shareBook=this

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp:ShareBookFragmentViewModel by viewModels()
        viewModel=temp
    }

    fun buttonkitapEkle(satici_adi:String,urun_adi:String,urun_fiyat:String,urun_aciklama:String, urun_gorsel_url:String){
        viewModel.kayit(satici_adi,urun_adi,urun_fiyat,urun_aciklama,urun_gorsel_url)
    }





}