package com.rabitech.mara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.rabitech.mara.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerlayout: DrawerLayout
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        navController = findNavController(R.id.myNavHostFragment)

        setupDrawer()

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when(destination.id ) {
                R.id.login -> {
                    binding.apply {
                        toolbarMain.visibility = View.GONE
                        navView.visibility = View.GONE
                    }
                }
                else -> {
                    binding.apply {
                        toolbarMain.visibility = View.VISIBLE
                        navView.visibility = View.VISIBLE

                    }
                }
            }
        }


    }

    private fun setupDrawer() {
        drawerlayout = binding.drawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment), drawerlayout)


        toolbar.setupWithNavController(navController,appBarConfiguration)
        findViewById<NavigationView>(R.id.nav_view)
            .setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerlayout)
    }
}
