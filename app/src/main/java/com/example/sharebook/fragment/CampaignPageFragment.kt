package com.example.sharebook.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.sharebook.R
import com.example.sharebook.adapter.PagerAdapter
import com.example.sharebook.databinding.FragmentCampaignPageBinding
import com.example.sharebook.entity.Books
import com.example.sharebook.viewmodel.MainPageFragmentViewModel
import kotlinx.android.synthetic.main.fragment_campaign_page.*


class CampaignPageFragment : Fragment() {
    private lateinit var tasarim: FragmentCampaignPageBinding
    private lateinit var discadapter: PagerAdapter
    private lateinit var viewModel: MainPageFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim= DataBindingUtil.inflate(inflater,R.layout.fragment_campaign_page, container, false)


        var indirimli_mi=0
        val discountBooks=ArrayList<Books>()
        viewModel.booksList.observe(viewLifecycleOwner, { discBookList ->
            val bookDisc=discBookList
            if(bookDisc !=null){
                for(i in 0 until bookDisc.size){
                    indirimli_mi=bookDisc.get(i).urun_indirimli_mi.toInt()

                    if (bookDisc.get(i).urun_indirimli_mi =="1"){
                        discountBooks.add(bookDisc.get(i))
                        discadapter = PagerAdapter(requireContext(), discountBooks, viewModel)
                        tasarim.discAdapter = discadapter
                        //tasarim.indicator.setViewPager(tasarim.viewPagerr)



                    }

                }
            }


        })


        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: MainPageFragmentViewModel by viewModels()
        viewModel = tempViewModel
    //dots_indicator.setViewPager2(viewPagerr)
    }

}