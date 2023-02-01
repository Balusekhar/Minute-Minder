package com.sampleprojects.minuteminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var tvAgeInDays: TextView
    private lateinit var tvAgeInMinutes: TextView
    private lateinit var tvAgeInSeconds: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)
        tvAgeInDays = findViewById(R.id.tvAgeInDays)
        tvAgeInSeconds = findViewById(R.id.tvAgeiInSeconds)

        val bundle : Bundle? = intent.extras
        val ageInDays = bundle?.getLong("ageInDays")
        val ageInMinutes = bundle?.getLong("ageInMinutes")
        val ageInSeconds = bundle?.getLong("ageInSeconds")

        tvAgeInDays.text = ageInDays.toString()
        tvAgeInMinutes.text = ageInMinutes.toString()
        tvAgeInSeconds.text = ageInSeconds.toString()
    }
}