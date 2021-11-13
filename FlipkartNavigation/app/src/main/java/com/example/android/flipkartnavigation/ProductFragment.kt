package com.example.android.flipkartnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.android.flipkartnavigation.databinding.FragmentProductBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        val binding=FragmentProductBinding.inflate(layoutInflater, container, false)

        //Setting up the text using safe args and data binding
        val args:ProductFragmentArgs by navArgs()

        binding.apply {
            item=args.productName
            invalidateAll()
        }

        return binding.root
    }

}