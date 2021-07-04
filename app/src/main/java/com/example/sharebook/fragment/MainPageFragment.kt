package com.example.sharebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.sharebook.R
import com.example.sharebook.adapter.BooksAdapter
import com.example.sharebook.databinding.FragmentMainPageBinding
import com.example.sharebook.viewmodel.BookListFragmentViewModel
import kotlinx.android.synthetic.main.fragment_main_page.*


class MainPageFragment : Fragment() {
   private lateinit var tasarim:FragmentMainPageBinding
   private lateinit var viewModel: BookListFragmentViewModel
    private lateinit var adapter: BooksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_main_page, container, false)
        tasarim.mainFragment=this



            viewModel.booksList.observe(viewLifecycleOwner, { list ->
            adapter = BooksAdapter(requireContext(), list, viewModel)
            tasarim.adapterFragment = adapter
                //viewModel.loadBooks()
        })
        tasarim.toolCart.setOnClickListener{
            Navigation.findNavController(toolCart).navigate(R.id.cartPageFragment)
        }

        return  tasarim.root
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: BookListFragmentViewModel by viewModels()
        viewModel = tempViewModel


    }





}