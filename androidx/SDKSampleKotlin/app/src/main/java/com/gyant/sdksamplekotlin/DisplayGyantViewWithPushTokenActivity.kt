package com.gyant.sdksamplekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout

import com.gyant.chat_sdk.CompletionHandler
import com.gyant.chat_sdk.GyantChat
import com.gyant.chat_sdk.GyantView
import com.gyant.chat_sdk.GyantOnPushTokenListener


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


    override fun getPushToken(callback: CompletionHandler<String>) {
        callback.onComplete("token123")
    }
}