package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var topFragment: TopFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topFragment = TopFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.top_container, topFragment)
            .replace(R.id.bottom_container, BottomFragment())
            .commit()
    }

    override fun onBackPressed() {
        if (topFragment.childFragmentManager.backStackEntryCount > 0) {
            topFragment.childFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}