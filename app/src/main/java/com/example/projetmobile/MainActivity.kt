package com.example.projetmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetmobile.presentation.MenuFragment
import com.example.projetmobile.presentation.detail.PCDetailFragment
import com.example.projetmobile.presentation.list.PC
import com.example.projetmobile.presentation.list.PCListFragment

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

     fun navigateToPCDetailFragment(pc: PC) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PCDetailFragment(), "")
            .addToBackStack(null)
            .commit()
    }

}