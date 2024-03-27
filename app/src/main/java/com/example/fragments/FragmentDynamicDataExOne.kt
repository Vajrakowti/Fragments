package com.example.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

class FragmentDynamicDataExOne : Fragment() {

    lateinit var editText: EditText
    lateinit var msg:String
    lateinit var comm:OnDataListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val v: View = inflater.inflate(R.layout.fragment_dynamic_data_ex_one, container, false)
        editText = v.findViewById(R.id.edtTxt)

        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                comm.communicate(editText.text.toString())
            }
        })
        return  v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        comm = context as OnDataListener
    }
}