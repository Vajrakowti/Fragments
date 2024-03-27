package com.example.fragments

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class DynamicFragmentDataEx : AppCompatActivity(), OnDataListener {
    var sendData = ""
    var senddata2 = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_dynamic_fragment_data_ex)

        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()

        if(savedInstanceState != null){
            senddata2 = savedInstanceState.getString("K1")!!
        }
        // get the display mode
        val displaymode = resources.configuration.orientation

        if (displaymode == 1){ // it portrait mode
            val f1 = FragmentDynamicDataExOne()
            fragmentTransaction.replace(android.R.id.content, f1)
        }
        else { // it landscape
            val f2 = FragmentDynamicDataExTwo()
            fragmentTransaction.replace(android.R.id.content, f2)
            // if(senddata2 != null)
             f2.displayReceivedData(senddata2)
        }
        fragmentTransaction.commit()
    }

    override fun communicate(msg: String) {
        sendData = msg
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("K1", sendData)
    }
}