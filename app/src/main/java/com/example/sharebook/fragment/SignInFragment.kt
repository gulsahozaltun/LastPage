package com.example.sharebook.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.sharebook.R
import com.example.sharebook.databinding.FragmentSignInBinding
import com.example.sharebook.entity.Customers
import com.example.sharebook.viewmodel.SignInFragmentViewModel
import com.google.gson.Gson


class SignInFragment : Fragment() {
        private lateinit var viewModel:SignInFragmentViewModel
        private lateinit var tasarim:FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_sign_in, container, false)
        tasarim.girisObj=this




        //var SharedPreferences=requireContext().getSharedPreferences()
        viewModel.kullaniciList.observe(viewLifecycleOwner,{
            kullaniciList->
            if(kullaniciList !=null){
                saveUser(kullaniciList)
                Navigation.findNavController(tasarim.buttonSignIn).navigate(R.id.mainPageFragment)

            }

            else{
                val message=R.string.validate_toast
                Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()            }
        })



        tasarim.button2.setOnClickListener {
            Navigation.findNavController(tasarim.button2).navigate(R.id.signUpFragment)
        }
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: SignInFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun girisYap(mail_adres:String,sifre:String){
        viewModel.girisYap(mail_adres,sifre)

    }

    fun saveUser(user : Customers){
        val mPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val prefsEditor = mPrefs.edit()
        val gson = Gson()
        val jsonUser = gson.toJson(user)
        prefsEditor.putString("user",jsonUser).apply()
    }


}



