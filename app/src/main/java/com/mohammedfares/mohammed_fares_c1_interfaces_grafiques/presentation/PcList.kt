package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.presentation

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.R
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.comon.Constante
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.comon.Resource
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.databinding.ErrorBinding
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.databinding.FragmentPcListBinding
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.databinding.LoadingBinding
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.presentation.adapters.PcAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PcList : Fragment() {

    private lateinit var binding: FragmentPcListBinding
    private lateinit var dialogBinding: ErrorBinding
    private lateinit var dialogLoadingBinding: LoadingBinding
    private var alertDialog: AlertDialog? = null
    val pcListViewModel: PcListViewModel by viewModels()
    private lateinit var adpter: PcAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPcListBinding.inflate(inflater,container,false)

        dialogBinding = ErrorBinding.inflate(layoutInflater)
        dialogLoadingBinding = LoadingBinding.inflate(layoutInflater)

        adpter = PcAdapter()
        binding.ordinatorList.layoutManager = GridLayoutManager(requireContext(),2)
        binding.ordinatorList.adapter = adpter
        binding.ordinatorList.setHasFixedSize(true)



        viewLifecycleOwner.lifecycleScope.launch {
            pcListViewModel.pcStateFlow.collect {
                when (it){
                    is Resource.Error -> {
                        Constante.showErrorDialog(
                            context = requireContext(),
                            dialogBinding = dialogBinding,
                            image = R.drawable.netwok_error,
                            message = "Network Error !!"
                        )
                    }
                    is Resource.Loading -> {
                        alertDialog = Constante.showLoadingDialog(requireContext(),dialogLoadingBinding)
                    }
                    is Resource.Success -> {

                        adpter.submitList(it.data)
                        delay(50L)
                        alertDialog?.let {
                            it.dismiss()
                        }
                    }
                }
            }
        }


        return binding.root
    }





}