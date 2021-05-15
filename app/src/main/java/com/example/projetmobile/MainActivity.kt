package com.example.projetmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.projetmobile.presentation.AboutFragment
import com.example.projetmobile.presentation.MenuFragment
import com.example.projetmobile.presentation.detail.PCDetailFragment
import com.example.projetmobile.presentation.detail.PCDetailFragment.Companion.KEY_JSON
import com.example.projetmobile.presentation.list.PC
import com.example.projetmobile.presentation.list.PCListFragment
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MenuFragment(), "")
            .commit()
    }


    fun navigateToListFragment () {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PCListFragment(), "")
            .addToBackStack(null)
            .commit()
    }

    fun navigateToAboutFragment () {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AboutFragment(), "")
            .addToBackStack(null)
            .commit()
    }

     fun navigateToPCDetailFragment(pc: PC) {
         val jsonPC = Gson().toJson(pc)
         val fragment = PCDetailFragment().apply {
             arguments = bundleOf(KEY_JSON to jsonPC)
         }
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment,"")
            .addToBackStack(null)
            .commit()
    }

}