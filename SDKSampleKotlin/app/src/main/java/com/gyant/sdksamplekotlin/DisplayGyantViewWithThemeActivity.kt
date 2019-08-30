package com.gyant.sdksamplekotlin

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout

import com.gyant.gyantchatsdk.GyantChat
import com.gyant.gyantchatsdk.GyantView


import java.util.HashMap

class DisplayGyantViewWithThemeActivity : AppCompatActivity() {
    internal lateinit var gyantView: GyantView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_gyant_view)

        val botPalette = HashMap<String, String>()
        botPalette["primaryColor1"] = "ff0000"

        val providerPalette = HashMap<String, String>()
        botPalette["primaryColor1"] = "00ff00"


        val themeMap = HashMap<String, Map<String, String>>()
        themeMap["bot"] = botPalette
        themeMap["provider"] = providerPalette

        GyantChat.start( "client_id",  "patient_id", true, themeMap)

        this.gyantView = GyantChat.creatView(this, lifecycle)

        val frameLayout = findViewById(R.id.frame_layout) as FrameLayout
        frameLayout.addView(gyantView)

    }

    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        this.gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
