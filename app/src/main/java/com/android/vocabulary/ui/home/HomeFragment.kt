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


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel = ViewModelProviders.of(activity!!).get(HomeViewModel::class.java)

        val adapter = VocabularyAdapter()
        viewPager = root.findViewById(R.id.home_view_pager)
        viewPager.adapter = adapter

        if (homeViewModel.position > 0){
            Log.e(TAG, "set current " + homeViewModel.position)
            Handler().postDelayed({
                viewPager.setCurrentItem(homeViewModel.position)
            }, 100)

        }

        homeViewModel.vocabulary.observe(this, Observer {
            adapter.addVocabularys(it)
        })

        onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                Log.e(TAG, "position " + position)
                if (position == adapter.itemCount - 1){
                    homeViewModel.getVocabularys()
                }
            }
        }

        Log.e(TAG, hashCode().toString())

        viewPager.registerOnPageChangeCallback(onPageChangeCallback)

        return root
    }


    override fun onPause() {
        super.onPause()

        viewPager.unregisterOnPageChangeCallback(onPageChangeCallback)
        homeViewModel.position = viewPager.currentItem
        Log.e(TAG, "Pause " + homeViewModel.position.toString())
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume" + homeViewModel.position.toString())
    }
}
