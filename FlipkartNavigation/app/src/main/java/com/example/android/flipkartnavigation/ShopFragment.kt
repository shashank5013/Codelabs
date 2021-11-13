package com.example.android.flipkartnavigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.flipkartnavigation.databinding.FragmentShopBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ShopFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        val binding=FragmentShopBinding.inflate( layoutInflater,container, false)

        //Setting on click listener for navigating to product fragment
        binding.headphonesButton.setOnClickListener {
            findNavController().navigate(ShopFragmentDirections.actionShopFragmentToProductFragment("Headphones"))
        }
        binding.mouseButton.setOnClickListener {
            findNavController().navigate((ShopFragmentDirections.actionShopFragmentToProductFragment("Mouse")))
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    /** Inflate options menu */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shop_menu,menu)
    }

    /** Action when Menu item is selected */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,findNavController())||super.onOptionsItemSelected(item)
    }
}