package com.gyant.sdksamplekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import com.gyant.gyantchatsdk.CompletionHandler

import com.gyant.gyantchatsdk.GyantChat
import com.gyant.gyantchatsdk.GyantView
import com.gyant.gyantchatsdk.GyantOnPushTokenListener


class DisplayGyantViewWithPushTokenActivity : AppCompatActivity(), GyantOnPushTokenListener {
    internal lateinit var gyantView: GyantView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_gyant_view)

        val gyantChat = GyantChat.getInstance()
            .clientId("client_id")
            .patientId("patient_id")
            .setOnPushTokenListener(this)
            .isDev(true)
            .start()

        this.gyantView = gyantChat.createView(this, lifecycle)

        val frameLayout = findViewById<View>(R.id.frame_layout) as FrameLayout
        frameLayout.addView(gyantView)
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        this.gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    override fun getToken(callback: CompletionHandler) {
        callback.onComplete("token123")
    }
}