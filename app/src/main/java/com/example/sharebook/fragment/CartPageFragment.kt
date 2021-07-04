package com.example.sharebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.sharebook.R
import com.example.sharebook.adapter.CartAdapter
import com.example.sharebook.databinding.FragmentCartPageBinding
import com.example.sharebook.entity.Books
import com.example.sharebook.viewmodel.MainPageFragmentViewModel


class CartPageFragment : Fragment() {
    private lateinit var tasarim:FragmentCartPageBinding
    private lateinit var viewModel:MainPageFragmentViewModel
    private lateinit var adapter: CartAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_cart_page, container, false)
        val carttBooks=ArrayList<Books>()
        var sepet_ekli_mi=0
        viewModel.booksList.observe(viewLifecycleOwner, { cartBooks ->
            val bookCart=cartBooks
            if(bookCart !=null){
                for(i in 0 until bookCart.size){
                    sepet_ekli_mi=bookCart.get(i).sepet_durum

                    if (bookCart.get(i).sepet_durum ==1){

                        carttBooks.add(bookCart.get(i))
                        adapter = CartAdapter(requireContext(), carttBooks, viewModel)
                        tasarim.adapter = adapter
                        tasarim.reaction.setImageResource(R.drawable.morality)
                        tasarim.cartInfo.text="Great choice!"
/*                        val cart_message=R.string.cart_full_message
                        tasarim.cartInfo.text=cart_message.toString()*/

                    }

                }
            }
            else
            {
                tasarim.reaction.setImageResource(R.drawable.unhappy)
                val cart_message_second=R.string.card_caart_text
                tasarim.cartInfo.text=cart_message_second.toString()
            }


        })

        tasarim.fabButton.setOnClickListener{
            val message=R.string.toast_pay
            Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()            }
        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: MainPageFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }


}