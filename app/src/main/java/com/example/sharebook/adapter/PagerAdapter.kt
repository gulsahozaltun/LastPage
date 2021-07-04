package com.example.sharebook.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sharebook.R
import com.example.sharebook.databinding.PagerDesignBinding
import com.example.sharebook.entity.Books
import com.example.sharebook.fragment.CampaignPageFragmentDirections
import com.example.sharebook.fragment.MainPageFragmentDirections
import com.example.sharebook.viewmodel.MainPageFragmentViewModel
import com.squareup.picasso.Picasso

class PagerAdapter(var mContext: Context,
                   var bookList: ArrayList<Books>,
                   var viewModel: MainPageFragmentViewModel,

):RecyclerView.Adapter<PagerAdapter.Pager2ViewHolder>() {
       inner class Pager2ViewHolder(pagerBinding:PagerDesignBinding):RecyclerView.ViewHolder(pagerBinding.root){
           var cardDesign:PagerDesignBinding
           init {
                this.cardDesign=pagerBinding
            }
       }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder{
        var layoutInflater = LayoutInflater.from(parent.context)
        val design = PagerDesignBinding.inflate(layoutInflater,parent,false)
        return Pager2ViewHolder(design)
    }

    override fun onBindViewHolder(holder: PagerAdapter.Pager2ViewHolder, position: Int) {
        val book=bookList.get(position)
        val view=holder.cardDesign
        view.indirimObj=book
        val url=book.urun_gorsel_url
        Picasso.get().load(url).into(view.imageView5)

        var price:Double=book.urun_fiyat.toDouble()
        Log.e("gelen sonuc",price.toString())
        var sonuc:Double=price-5.0
        var sonuctoString:String=sonuc.toString()
        //Log.e("gelen sonuc",sonuc)
        view.indirimliFiyat.text=sonuctoString + '₺'
        holder.cardDesign.sepetBt.setOnClickListener {

        if(book.sepet_durum !=1){
            viewModel.sepeteEkle(book.id.toInt(),1)
            val message= R.string.toast_cart_add
            Toast.makeText(mContext,message, Toast.LENGTH_SHORT).show()  }

        else if(book.sepet_durum==1){
            Log.e("sepete eklendi bile",book.sepet_durum.toString())
        }
    }
        holder.cardDesign.detayBt.setOnClickListener {
            val transition= CampaignPageFragmentDirections.campaigntoDetail(book)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}