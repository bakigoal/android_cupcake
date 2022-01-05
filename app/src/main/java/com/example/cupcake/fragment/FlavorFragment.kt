package com.example.cupcake.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentFlavorBinding

class FlavorFragment : Fragment() {

    private var binding: FragmentFlavorBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View {
        val fragmentBinding = FragmentFlavorBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            nextButton.setOnClickListener { goToNextScreen() }
        }
    }

    private fun goToNextScreen() {
        val actionFlavorFragmentToPickupFragment =
            FlavorFragmentDirections.actionFlavorFragmentToPickupFragment()
        findNavController().navigate(actionFlavorFragmentToPickupFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}