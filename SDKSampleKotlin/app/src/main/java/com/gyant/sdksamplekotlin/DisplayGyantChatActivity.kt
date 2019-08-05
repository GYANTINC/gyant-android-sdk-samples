package com.gyant.sdksamplekotlin

import android.os.Bundle
import com.gyant.gyantchatsdk.GyantChat
import com.gyant.gyantchatsdk.GyantChatActivity

class DisplayGyantChatActivity : GyantChatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        GyantChat.start( "client_id",  "patient_id", true);
        super.onCreate(savedInstanceState)
    }
}
