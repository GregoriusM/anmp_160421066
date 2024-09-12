package com.ubaya.week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.ubaya.week1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //create new objek
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //navHostFragment dimasukan ke navController
        navController = (supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment).navController
        //supaya bisa di handle
        //param ke 3 adalah untuk drawer (ga wajib diisi)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)

        //NAVCONTROLLER MENGHANDLE BOTTOM BAR NAVIGATION
        //jgn lupa samain nama id di navigation dan di listmenu (UI)
        binding.bottomNav.setupWithNavController(navController)

        //untuk menghandle navView
        NavigationUI.setupWithNavController(binding.navView, navController)

    }

    //tombol back diserahkan semua ke navController, muncul logo back selain di home
    //function ini ada 2 opsi
    //jika hamburg dipencet, drawer terbuka || tapi jika yang ada adalah tombol back jadinya back
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp()
    }

}