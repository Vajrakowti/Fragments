package com.example.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import java.util.Calendar

class DataTimePickerEx : AppCompatActivity() {

    private lateinit var datePickerBtn : Button
    private lateinit var timePickerBtn : Button
    private lateinit var dateTxt : EditText
    private lateinit var timeTxt : EditText

    private var mYear : Int = 0
    private var mMonth : Int = 0
    private var mDay : Int = 0
    private var mHour : Int = 0
    private var mMinute : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_time_picker_ex)


        datePickerBtn = findViewById(R.id.datePickerBtn)
        timePickerBtn = findViewById(R.id.timePickerBtn)
        dateTxt = findViewById(R.id.dateText)
        timeTxt = findViewById(R.id.timeText)

        datePickerBtn.setOnClickListener {

            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]


            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    dateTxt.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                },
                mYear, mMonth, mDay)
            datePickerDialog.show()
        }

        timePickerBtn.setOnClickListener {

            val c = Calendar.getInstance()
            mHour = c[Calendar.HOUR]
            mMinute = c[Calendar.MINUTE]

            val timePickerDialog = TimePickerDialog(this,
                { view, hourOfDay, minute ->
                    var hourOfDay : Int  = hourOfDay
                    var AM_PM : String = if(hourOfDay<12){"AM"} else {"PM"}

                    if(AM_PM == "PM"){ hourOfDay -= 12}
                    if(hourOfDay == 0){ hourOfDay += 12}
                    if(minute<10)
                    {
                        timeTxt.setText("$hourOfDay:0$minute $AM_PM")
                    }
                    else
                    {
                        timeTxt.setText("$hourOfDay:$minute $AM_PM")
                    }
                },mHour,mMinute,false)
            timePickerDialog.show()
        }
    }
}