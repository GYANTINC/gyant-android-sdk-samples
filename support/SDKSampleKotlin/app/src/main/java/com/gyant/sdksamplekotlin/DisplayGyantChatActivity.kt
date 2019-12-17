package com.gyant.sdksamplekotlin

import android.os.Bundle

import com.gyant.chat_sdk.GyantChat
import com.gyant.chat_sdk.GyantChatActivity

class DisplayGyantChatActivity : GyantChatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        GyantChat.getInstance()
            .clientId("client_id")
            .isDev(true)
            .start()
        super.onCreate(savedInstanceState)
    }
}
