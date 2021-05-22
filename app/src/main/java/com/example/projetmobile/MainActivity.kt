package com.example.projetmobile

import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.bundleOf
import androidx.preference.PreferenceManager.getDefaultSharedPreferences
import com.example.projetmobile.presentation.AboutFragment
import com.example.projetmobile.presentation.MenuFragment
import com.example.projetmobile.presentation.detail.PCDetailFragment
import com.example.projetmobile.presentation.detail.PCDetailFragment.Companion.KEY_JSON
import com.example.projetmobile.presentation.list.PC
import com.example.projetmobile.presentation.list.PCListFragment
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences;
    private lateinit var editor: SharedPreferences.Editor
    private var itheme: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getDefaultSharedPreferences(this) // 0 - for private mode
        editor = sharedPreferences.edit()
        itheme = sharedPreferences.getInt("theme", 1)
        println(itheme)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(itheme)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MenuFragment(), "")
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.settings, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.theme_dark -> {
                Toast.makeText(this, "Dark theme selected", Toast.LENGTH_SHORT).show()
                //setTheme(R.style.Dark)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putInt("theme", AppCompatDelegate.MODE_NIGHT_YES)
                editor.commit()

                true
            }
            R.id.theme_light -> {
                Toast.makeText(this, "Light theme selected", Toast.LENGTH_SHORT).show()
                //setTheme(R.style.Light)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putInt("theme", AppCompatDelegate.MODE_NIGHT_NO)
                editor.commit()

                true
            }
            R.id.language -> {
                Toast.makeText(this, "Language selected", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
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
