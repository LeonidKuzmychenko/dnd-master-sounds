package com.example.dnd_master_app

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dnd_master_app.databinding.ActivityMainBinding
import com.example.dnd_master_app.parent.adapter.SoundController
import com.example.dnd_master_app.parent.dto.SoundItem
import com.example.dnd_master_app.service.MediaService
import com.example.dnd_master_app.service.PermissionService
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), SoundController {


    private val permission: PermissionService = PermissionService()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaService: MediaService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_environment,
                R.id.nav_box,
                R.id.nav_floor,
                R.id.nav_door,
                R.id.nav_surprise
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        mediaService = MediaService(this)
        permission.checkPermission(this)
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun changeSound(data: SoundItem) {
        mediaService.changeSound(data)
    }
}