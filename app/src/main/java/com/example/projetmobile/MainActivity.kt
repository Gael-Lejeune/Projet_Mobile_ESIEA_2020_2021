package com.example.projetmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetmobile.presentation.MenuFragment
import com.example.projetmobile.presentation.list.PCListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MenuFragment(), "")
            .commit()
    }

}