package com.example.sharebook.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.sharebook.R
import com.example.sharebook.databinding.FragmentSignUpBinding
import com.example.sharebook.viewmodel.SignUpFragmentViewModel


class SignUpFragment : Fragment() {
    private lateinit var tasarim:FragmentSignUpBinding
    private lateinit var viewModel:SignUpFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up, container, false)
        tasarim.signUpFragement=this



        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp:SignUpFragmentViewModel by viewModels()
        viewModel=temp
    }
  fun buttonKisiEkle(mail_adres: String, sifre: String, ad_soyad: String, telefon: String){
      viewModel.kisiEkle(mail_adres, sifre, ad_soyad, telefon)
      Log.e("gelenlerr", mail_adres+sifre+ad_soyad+telefon)
      Navigation.findNavController(tasarim.button3).navigate(R.id.signInFragment)
      val message=R.string.register_success
      Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()

  }

}