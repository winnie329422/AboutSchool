package com.example.aboutschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var mMainNav: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(Home())

        findViewById<BottomNavigationView>(R.id.toolbar_bottom).also { mMainNav = it }
        mMainNav?.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.p1 -> setFragment(Home())
                R.id.p2 -> setFragment(Department())
                R.id.p3 -> startActivity(Intent(this@MainActivity, Map::class.java))

                R.id.p4 -> setFragment(Food())
            }
            true
        })
    }



    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}