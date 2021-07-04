package com.example.sharebook.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sharebook.R
import com.example.sharebook.databinding.CardCartBinding
import com.example.sharebook.entity.Books
import com.example.sharebook.fragment.CampaignPageFragmentDirections
import com.example.sharebook.viewmodel.MainPageFragmentViewModel
import com.squareup.picasso.Picasso

class CartAdapter(var mContext: Context,
                  var bookList: ArrayList<Books>,
                  var viewModel:MainPageFragmentViewModel):RecyclerView.Adapter<CartAdapter.CartDesignBinding> (){

    inner class CartDesignBinding(cartBinding:CardCartBinding):RecyclerView.ViewHolder(cartBinding.root){
        var cardCart: CardCartBinding
        init {
            this.cardCart=cartBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartDesignBinding {
        val layoutInflater= LayoutInflater.from(mContext)
        val tasarim= CardCartBinding.inflate(layoutInflater,parent,false)
        return CartDesignBinding(tasarim)
    }

    override fun onBindViewHolder(holder: CartDesignBinding, position: Int) {
        val book=bookList.get(position)
        val view= holder.cardCart
        view.bookObj=book
        val url=book.urun_gorsel_url
        Picasso.get().load(url).into(view.imgCart)
        view.imageButton2.setOnClickListener {
            if(book.sepet_durum !=0){
                viewModel.sepettenCikar(book.id.toInt(),0)
                Log.e("sepette cikartildi",book.sepet_durum.toString())
                val message= R.string.toast_delete
                Toast.makeText(mContext,message, Toast.LENGTH_SHORT).show()
            }
            else{

            }
            view.cardView.setOnClickListener {
                val gecis=CampaignPageFragmentDirections.campaigntoDetail(book)
                Navigation.findNavController(it).navigate(gecis)
            }

/*            else if(book.sepet_durum==1){
            Log.e("sepette cikartildi",book.sepet_durum.toString())
            }*/
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }


}