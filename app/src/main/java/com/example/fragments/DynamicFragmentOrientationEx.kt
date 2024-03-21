package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class DynamicFragmentOrientationEx : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_fragment_orientation_ex)

        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fm.beginTransaction()
        val displaymode = resources.configuration.orientation
        if(displaymode == 1) { // it portrait mode
            val f1 = DynamicFragOrientExOne()
            fragmentTransaction.replace(android.R.id.content, f1)
        }

        else{ // it landscape
            val f2 = DynamicFragOrientExTwo()
            fragmentTransaction.replace(android.R.id.content, f2)
        }
        fragmentTransaction.commit()
    }
}