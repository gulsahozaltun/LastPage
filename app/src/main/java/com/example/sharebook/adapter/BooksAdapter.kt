package com.example.sharebook.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sharebook.R
import com.example.sharebook.databinding.CardBookBinding
import com.example.sharebook.entity.Books
import com.example.sharebook.fragment.MainPageFragmentDirections
import com.example.sharebook.viewmodel.BookListFragmentViewModel
import com.squareup.picasso.Picasso

class BooksAdapter(var mContext:Context,
                   var booksList: List<Books>,
                   var viewModel: BookListFragmentViewModel,

)
    :RecyclerView.Adapter<BooksAdapter.CardDesignHolder>() {
        inner class CardDesignHolder(cardBookBinding: CardBookBinding):
                RecyclerView.ViewHolder(cardBookBinding.root){
                    var cardDesignBinding:CardBookBinding
            init{
                this.cardDesignBinding=cardBookBinding
            }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater=LayoutInflater.from(mContext)
        val tasarim=CardBookBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val book=booksList.get(position)
        val view= holder.cardDesignBinding
        view.bookObject=book


        val url=book.urun_gorsel_url
        Picasso.get().load(url).into(view.imgBook)
        holder.cardDesignBinding.imageButton.setOnClickListener {
            viewModel.sepeteEkle(book.id.toInt(),book.sepet_durum)
            Log.e("book ve  id", book.id+book.sepet_durum.toString()+book.urun_adi)
            Log.e("sepet durum", book.sepet_durum.toString()+"  "+book.urun_adi)
        }

        holder.cardDesignBinding.cardView.setOnClickListener {
            val transition= MainPageFragmentDirections.bookDetailAction(book)
            Navigation.findNavController(it).navigate(transition)
        }

        holder.cardDesignBinding.imageButton.setOnClickListener {
            if(book.sepet_durum !=1){
            viewModel.sepeteEkle(book.id.toInt(),1)
                val message= R.string.toast_cart_add
                Toast.makeText(mContext,message, Toast.LENGTH_SHORT).show()   }
            else if(book.sepet_durum==1){
                val message= R.string.toas_exist
                Toast.makeText(mContext,message, Toast.LENGTH_SHORT).show()

            }
            //viewModel.sepeteEkle(book.id.toInt(),0)
     }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }
}