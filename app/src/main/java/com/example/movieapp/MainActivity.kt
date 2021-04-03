package com.example.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val bind = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val findNavController = this.findNavController(R.id.navHostFragment)
        drawerLayout = bind.drawerLayout
        NavigationUI.setupActionBarWithNavController(this, findNavController, drawerLayout) //action bar oben
        NavigationUI.setupWithNavController(bind.navView, findNavController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(this.findNavController(R.id.navHostFragment), drawerLayout) //uses the button top left instead of the nav button from android
    }
}