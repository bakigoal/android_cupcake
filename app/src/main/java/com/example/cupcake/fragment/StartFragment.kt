package com.example.cupcake.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.R
import com.example.cupcake.databinding.FragmentStartBinding
import com.example.cupcake.viewmodel.OrderViewModel

class StartFragment : Fragment() {

    private var binding: FragmentStartBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun orderCupcake(quantity: Int) {
        sharedViewModel.setQuantity(quantity)
        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }
        val toFlavorFragment = StartFragmentDirections.actionStartFragmentToFlavorFragment()
        findNavController().navigate(toFlavorFragment)
    }
}