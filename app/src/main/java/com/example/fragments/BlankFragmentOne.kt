package com.example.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.service.media.MediaBrowserService.BrowserRoot
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
//import java.lang.ClassCastException
//import kotlin.ClassCastException

class BlankFragmentOne : Fragment() {
    lateinit var v: View
    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        v = inflater.inflate(R.layout.fragment_blank_one,container,false)
        init(container)
        return v
    }
    private lateinit var buttonListener: OnButtonPressListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        buttonListener=
            try {
                activity as OnButtonPressListener
            }
            catch (e: ClassCastException){
                throw ClassCastException("$context must implement" + "onButtonPressed")
            }
    }

    private fun init(root: ViewGroup?) {
        val but: Button = v.findViewById(R.id.send)
        val clear: Button = v.findViewById(R.id.send2)

        Toast.makeText(context,"init", Toast.LENGTH_LONG).show()
        but.setOnClickListener {
            buttonListener.onButtonPressed("Button has been clicked")
        }
        clear.setOnClickListener {
            buttonListener.onButtonPressed("Cleared")
        }
    }
}