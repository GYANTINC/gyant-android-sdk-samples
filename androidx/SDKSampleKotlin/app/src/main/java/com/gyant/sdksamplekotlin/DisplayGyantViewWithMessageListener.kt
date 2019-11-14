package com.gyant.sdksamplekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.FrameLayout

import com.gyant.chat_sdk.GyantChat
import com.gyant.chat_sdk.GyantOnMessageListener
import com.gyant.chat_sdk.GyantView


class DisplayGyantViewWithMessageListener : AppCompatActivity(), GyantOnMessageListener {
    internal lateinit var gyantView: GyantView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_gyant_view)

        val gyantChat = GyantChat.getInstance()
            .clientId("client_id")
            .patientId("patient_id")
            .onMessage(this)
            .isDev(true)
            .start()

        this.gyantView = gyantChat.createView(this, lifecycle)

        val frameLayout = findViewById(R.id.frame_layout) as FrameLayout
        frameLayout.addView(gyantView)
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        this.gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onMessage(message: String) {
        Log.d("GyantMessage", message)
    }
}