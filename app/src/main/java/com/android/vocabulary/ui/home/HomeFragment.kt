package com.android.vocabulary.ui.home

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.android.vocabulary.R

class HomeFragment : Fragment() {

    companion object {
        val TAG = "HomeFragment"
    }


    private lateinit var homeViewModel: HomeViewModel
    private lateinit var viewPager: ViewPager2
    private lateinit var onPageChangeCallback: ViewPager2.OnPageChangeCallback
    private var init = true


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val adapter = VocabularyAdapter()

        homeViewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)
        viewPager = root.findViewById(R.id.home_view_pager)
        viewPager.adapter = adapter


        homeViewModel.vocabulary.observe(this, Observer {
            adapter.addVocabularys(it)
        })


        homeViewModel.position.let {
            if (it <= 0){
                return@let
            }
            Handler().postDelayed({
                viewPager.setCurrentItem(it, false)
            }, 50)
        }


        onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == adapter.itemCount - 1){
                    homeViewModel.getVocabularys()
                }
            }
        }

        viewPager.registerOnPageChangeCallback(onPageChangeCallback)

        return root
    }


    override fun onPause() {
        super.onPause()
        viewPager.unregisterOnPageChangeCallback(onPageChangeCallback)
        homeViewModel.position = viewPager.currentItem
    }
}
