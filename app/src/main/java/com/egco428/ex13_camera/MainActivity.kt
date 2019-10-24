package com.egco428.ex13_camera

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1 //can be any value

    override fun isInMultiWindowMode(): Boolean {
        return super.isInMultiWindowMode()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!hasCamera()){
            photoBtn.setEnabled(false)
        }
    }

    private fun hasCamera():Boolean{
        return packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)
    }

    fun launchCamera(view: View){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE) //เปิดกล้องของ android
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE) //เอาภาพกลับมาหน้า Main

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            val extras = data!!.extras
            val photo = extras!!.get("data") as Bitmap
            photoView.setImageBitmap(photo)
        }
    }


}
