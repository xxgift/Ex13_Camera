package com.egco428.ex13_camera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1 //can be any value

    override fun isInMultiWindowMode(): Boolean {
        return super.isInMultiWindowMode()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
