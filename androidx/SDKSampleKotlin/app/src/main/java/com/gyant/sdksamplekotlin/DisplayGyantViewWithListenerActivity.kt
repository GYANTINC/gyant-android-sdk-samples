package com.gyant.sdksamplekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.FrameLayout
import com.gyant.chat_sdk.*


class DisplayGyantViewWithListenerActivity : AppCompatActivity(), GyantChatListener {
    private lateinit var gyantView: GyantView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic)

        val gyantChat = GyantChat.getInstance()
            .clientId("client_id")
            .listener(this)
            .isDev(true)
            .start()

        gyantView = gyantChat.createView(this, lifecycle)

        val frameLayout = findViewById<FrameLayout>(R.id.frame_layout)
        frameLayout.addView(gyantView)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onDiagnosis(diagnosis: MutableMap<Any?, Any?>?) {
        Log.d("GyantDiagnosis", diagnosis.toString())
    }

    override fun onMessage(message: String) {
        Log.d("GyantMessage", message)
    }

    override fun getPushToken(p0: CompletionHandler<String>?) {
        TODO("not implemented")
    }

}