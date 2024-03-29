package com.example.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class BlankFragmentTwo : Fragment() {

    lateinit var textView: TextView
    lateinit var v1: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        v1 = inflater.inflate(R.layout.fragment_blank_two, container, false)
        return v1
    }

    fun onFragmentInteraction(uri : String){
        Log.d("sudha",uri)
        textView = v1.findViewById(R.id.tv1)
        textView.setText(uri)
    }
}