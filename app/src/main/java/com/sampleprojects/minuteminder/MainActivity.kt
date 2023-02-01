package com.sampleprojects.minuteminder

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var textPicker: Button
    private lateinit var resultbtn: Button
    private var tvSelectedDate: TextView? = null

    var ageInDays : Long =0
    var ageInMinutes : Long =0
    var ageInSeconds : Long =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textPicker = findViewById(R.id.btnDataPicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        resultbtn = findViewById(R.id.resultbtn)

        textPicker.setOnClickListener {
            clickDatePicker()
        }

        resultbtn.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("ageInDays",ageInDays)
            intent.putExtra("ageInMinutes",ageInMinutes)
            intent.putExtra("ageInSeconds",ageInSeconds)
            startActivity(intent)
        }

        Log.d("test","OnCreate")

    }


    private fun clickDatePicker() {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,{button,SelectedYear, Selectedmonth, SelecteddayOfMonth ->

        },year,month,day)


        val dpd = DatePickerDialog(this, { textPicker, SelectedYear, Selectedmonth, SelecteddayOfMonth ->

            val selectedDate = "$SelecteddayOfMonth/${Selectedmonth+1}/$SelectedYear"
            tvSelectedDate?.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val dateObject = sdf.parse(selectedDate) //Parse the selected date string into a Date object
            val selectedDateInMilliseconds = dateObject.time //Get the selected date in milliseconds by using the time property of the Date object


            val myCalender = Calendar.getInstance()
            val currentDateInMilliseconds = myCalender.timeInMillis //Get the current date in milliseconds using the timeInMillis property of the Calendar object




            val differenceInDays = (currentDateInMilliseconds - selectedDateInMilliseconds)/ (1000 * 60 * 60 * 24)
            ageInDays = differenceInDays

            val differenceInMinutes = (currentDateInMilliseconds - selectedDateInMilliseconds)/ (1000 * 60 )
            ageInMinutes = differenceInMinutes

            val differenceInSeconds = (currentDateInMilliseconds - selectedDateInMilliseconds)/ (1000 )
            ageInSeconds = differenceInSeconds

            val differenceInMilliseconds = currentDateInMilliseconds - selectedDateInMilliseconds
            Toast.makeText(this,differenceInMilliseconds.toString(),Toast.LENGTH_LONG).show()


        }, year, month, day)
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86_400_000
        dpd.show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("test","OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("test","OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("test","OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("test","OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test","OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("test","OnRestart")
    }

}