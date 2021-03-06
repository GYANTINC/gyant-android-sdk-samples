package com.gyant.sdksamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull

import com.gyant.chat_sdk.GyantChat
import com.gyant.chat_sdk.GyantFragment

class DisplayFragmentActivity : AppCompatActivity() {
    private lateinit var frag: GyantFragment

    override fun onCreate(savedInstanceState: Bundle?) {

        val gyantChat = GyantChat.getInstance()
            .clientId("client_id")
            .isDev(true)
            .start()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic)

        frag = gyantChat.createFragment();

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout, frag,  BuildConfig.APPLICATION_ID + ".GyantFragment")
            .commit();
    }

    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        frag.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
