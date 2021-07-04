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
import androidx.navigation.fragment.navArgs
import com.example.sharebook.R
import com.example.sharebook.databinding.FragmentBookDetailBinding
import com.example.sharebook.viewmodel.MainPageFragmentViewModel
import com.squareup.picasso.Picasso


class BookDetailFragment : Fragment() {
    private lateinit var tasarim: FragmentBookDetailBinding
    private lateinit var viewModel: MainPageFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_book_detail, container, false)

        val bundle:BookDetailFragmentArgs by navArgs()
        val bookArg= bundle.bookArg
        tasarim.bookObj=bookArg
        tasarim.button4.setOnClickListener {
            if(bookArg.sepet_durum !=1){
                viewModel.sepeteEkle(bookArg.id.toInt(),1)
                val message= R.string.toast_cart_add
                Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()  }

            else if(bookArg.sepet_durum==1){
                val message= R.string.toas_exist
                Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
            }
        }
     val url=bookArg.urun_gorsel_url
        Picasso.get().load(url).into(tasarim.imageView4)




        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: MainPageFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }




        }


