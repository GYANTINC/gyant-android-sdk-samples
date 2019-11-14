package com.gyant.sdksamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import android.widget.FrameLayout

import com.gyant.chat_sdk.GyantChat
import com.gyant.chat_sdk.GyantView


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
