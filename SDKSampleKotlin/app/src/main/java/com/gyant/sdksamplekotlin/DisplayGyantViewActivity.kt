package com.gyant.sdksamplekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.widget.FrameLayout


import com.gyant.gyantchatsdk.GyantChat
import com.gyant.gyantchatsdk.GyantView

class DisplayGyantViewActivity : AppCompatActivity() {
    internal lateinit var gyantView: GyantView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_gyant_view)

        GyantChat.start( "client_id",  "patient_id", true)

        gyantView = GyantChat.creatView(this, lifecycle)

        val frame = findViewById<FrameLayout>(R.id.frame_layout)
        frame.addView(gyantView)
    }

    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        this.gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
