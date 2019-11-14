package com.gyant.sdksamplekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull

import com.gyant.chat_sdk.GyantChat
import com.gyant.chat_sdk.GyantFragment


class DisplayFragmentActivity : AppCompatActivity() {
    private lateinit var frag: GyantFragment

    override fun onCreate(savedInstanceState: Bundle?) {

        val gyantChat = GyantChat.getInstance()
            .clientId("client_id")
            .patientId("patient_id")
            .isDev(true)
            .start()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_fragment)

        frag = gyantChat.createFragment();

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout, frag,  BuildConfig.APPLICATION_ID + ".GyantFragment")
            .commit();
    }

    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        this.frag.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
