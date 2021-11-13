package com.example.android.flipkartnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.android.flipkartnavigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    //Binding variable for ViewBinding
    private lateinit var binding: ActivityMainBinding


    //Navigation Controller which handles Navigation
    private  lateinit var navController: NavController

    //AppBarConfiguration stores top level destinations
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflating the layout
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Initialising navigation controller
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController=navHostFragment.findNavController()

        //Setting up bottom navigation menu with navigation component
        binding.bottomNavigationView.setupWithNavController(navController)
        binding.myNavView.setupWithNavController(navController)

        //Setting up action bar with navigation component
        appBarConfiguration= AppBarConfiguration.Builder(
            R.id.shopFragment,
            R.id.superCoinFragment,
            R.id.creditFragment,
            R.id.quickFragment,
        ).setOpenableLayout(binding.drawerLayout).build()

        setupActionBarWithNavController(navController,appBarConfiguration)

        setBottomNavView()
    }

    /** Action when back button is pressed */
    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }

    /** Navigates back when up button is pressed */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    /** Hides Bottom Navigation View when unnecessary */
    private fun setBottomNavView() {
        navController.addOnDestinationChangedListener { _, dest, _->
            when(dest.id){
                R.id.shopFragment ->{
                    binding.bottomNavigationView.visibility=BottomNavigationView.VISIBLE
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
                R.id.superCoinFragment ->{
                    binding.bottomNavigationView.visibility=BottomNavigationView.VISIBLE
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
                R.id.creditFragment ->{
                    binding.bottomNavigationView.visibility=BottomNavigationView.VISIBLE
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
                R.id.quickFragment ->{
                    binding.bottomNavigationView.visibility=BottomNavigationView.VISIBLE
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
                else -> {
                    binding.bottomNavigationView.visibility=BottomNavigationView.GONE
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }
            }
        }
    }
}