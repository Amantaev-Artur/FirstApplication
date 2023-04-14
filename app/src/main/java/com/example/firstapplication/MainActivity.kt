package com.example.firstapplication

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    val columnPortrait = 3
    val columnLandscape = 4
    lateinit var courseGRV: GridView
    lateinit var courseList: List<String>
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        courseGRV = findViewById(R.id.idGRV)
        courseList = ArrayList()

        btn = findViewById(R.id.button)
        btn.setOnClickListener {
            courseList += courseList.size.toString()

            val courseAdapter = GridRVAdapter(courseList = courseList, this@MainActivity)

            courseGRV.adapter = courseAdapter
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        courseGRV = findViewById(R.id.idGRV)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            courseGRV.numColumns = columnLandscape
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            courseGRV.numColumns = columnPortrait
        }
    }
}