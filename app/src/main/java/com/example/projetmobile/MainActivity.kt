package com.example.projetmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.projetmobile.presentation.list.PCListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button_first)
        button.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PCListFragment(), "")
                    .commit()
        }
    }

}