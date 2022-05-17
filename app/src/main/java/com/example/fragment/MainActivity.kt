package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener

class MainActivity : AppCompatActivity(), TopFragment.Host {

    lateinit var topFragment: TopFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Tomato", "MainActivity.onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topFragment = TopFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.top_container, topFragment)
            .replace(R.id.bottom_container, BottomFragment())
            .commit()

//        supportFragmentManager.setFragmentResultListener(
//            "top_result",
//            this
//        ) { _, result ->
//            Toast.makeText(this, "Value = ${result.getInt("value")}", Toast.LENGTH_SHORT).show()
//        }
    }

    override fun onBackPressed() {
        if (topFragment.childFragmentManager.backStackEntryCount > 0) {
            topFragment.childFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onCountIncremented(count: Int) {
        Toast.makeText(this, "Value = $count", Toast.LENGTH_SHORT).show()
    }

    override fun closeActivity() {
        finish()
    }

    override fun onStart() {
        Log.d("Tomato", "MainActivity.onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Tomato", "MainActivity.onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Tomato", "MainActivity.onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Tomato", "MainActivity.onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("Tomato", "MainActivity.onDestroy")
        super.onDestroy()
    }
}