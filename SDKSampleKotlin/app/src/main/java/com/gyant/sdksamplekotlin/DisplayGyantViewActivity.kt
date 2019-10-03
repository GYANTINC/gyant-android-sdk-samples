package com.gyant.sdksamplekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.view.View
import android.widget.FrameLayout

import com.gyant.gyantchatsdk.GyantChat
import com.gyant.gyantchatsdk.GyantView


class DisplayGyantViewActivity : AppCompatActivity() {
    internal lateinit var gyantView: GyantView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_gyant_view)

        val gyantChat = GyantChat.getInstance()
            .clientId("client_id")
            .patientId("patient_id")
            .isDev(true)
            .start()

        gyantView = gyantChat.createView(this, lifecycle)

        val frame = findViewById<FrameLayout>(R.id.frame_layout)
        frame.addView(gyantView)
    }

    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        this.gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}
