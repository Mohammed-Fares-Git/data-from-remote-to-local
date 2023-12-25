package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.R
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.databinding.FragmentFavoritPcBinding


class FavoritPc : Fragment() {

    private lateinit var binding: FragmentFavoritPcBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFavoritPcBinding.inflate(inflater,container,false)



        return binding.root

    }

}