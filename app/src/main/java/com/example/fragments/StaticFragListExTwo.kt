package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class StaticFragListExTwo : Fragment() {
    lateinit var textos : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       val view:View =  inflater.inflate(R.layout.fragment_static_frag_list_ex_two, container, false)
        textos = view.findViewById(R.id.txtisp)
        return view
    }

    fun change(txt : String){
        textos.text = txt
    }
}