package com.example.sharebook.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.Settings.Global.getString
import android.provider.Settings.Secure.getString
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.sharebook.R
import com.example.sharebook.adapter.BooksAdapter
import com.example.sharebook.databinding.FragmentProfilBinding
import com.example.sharebook.entity.Customers
import com.example.sharebook.viewmodel.MainPageFragmentViewModel
import com.example.sharebook.viewmodel.SignInFragmentViewModel
import kotlinx.android.synthetic.main.fragment_profil.*
import com.example.sharebook.fragment.MainPageFragment
import com.google.gson.Gson


class ProfilFragment : Fragment() {
    private lateinit var viewModel:SignInFragmentViewModel
    private lateinit var kisiBilgiler:Customers
    private lateinit var tasarim:FragmentProfilBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_profil, container, false)

        tasarim.customersObj=getUser()
         return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: SignInFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun getUser() : Customers {
        val mPrefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())

        val gson = Gson()
        val jsonUser : String? = mPrefs.getString("user", "")
        return gson.fromJson(jsonUser, Customers::class.java)
    }


}