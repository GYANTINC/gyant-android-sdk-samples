package com.gyant.sdksamplekotlin

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout

import com.gyant.chat_sdk.GyantChat
import com.gyant.chat_sdk.GyantView

import java.util.HashMap

class DisplayGyantViewWithThemeActivity : AppCompatActivity() {
    private lateinit var gyantView: GyantView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generic)

        val botPalette = HashMap<String, String>()
        botPalette["primaryColor1"] = "ff0000"

        val providerPalette = HashMap<String, String>()
        botPalette["primaryColor1"] = "00ff00"

        val themeMap = HashMap<String, Map<String, String>>()
        themeMap["bot"] = botPalette
        themeMap["provider"] = providerPalette

        val gyantChat = GyantChat.getInstance()
            .clientId("client_id")
            .withTheme(themeMap)
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
