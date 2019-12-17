package com.gyant.sdksamplekotlin

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import android.widget.FrameLayout

import com.gyant.chat_sdk.GyantChat
import com.gyant.chat_sdk.GyantChatPatientData
import com.gyant.chat_sdk.GyantView

import java.util.HashMap


class DisplayGyantViewWithPatientDataActivity : AppCompatActivity() {
    private lateinit var gyantView: GyantView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic)

        val patientData = GyantChatPatientData()
        patientData.patientId = "<YOUR-PATIENT-ID>"
        patientData.visitReason = "fever"
        patientData.gender = "male"
        patientData.dateOfBirth = "2001-03-26T20:28:32.383+0000"

        val gyantChat = GyantChat.getInstance()
            .clientId("client_id")
            .patientData(patientData)
            .isDev(true)
            .start()

        gyantView = gyantChat.createView(this, lifecycle)

        val frameLayout = findViewById<FrameLayout>(R.id.frame_layout)
        frameLayout.addView(gyantView)
    }

    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
