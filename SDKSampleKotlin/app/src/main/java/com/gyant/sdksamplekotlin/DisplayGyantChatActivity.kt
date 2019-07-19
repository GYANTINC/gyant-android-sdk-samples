package com.gyant.sdksamplekotlin

import android.os.Bundle
import com.gyant.gyantchatsdk.GyantChat
import com.gyant.gyantchatsdk.GyantChatActivity

class DisplayGyantChatActivity : GyantChatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        GyantChat.start( "clientID",  "patientID", true);
        super.onCreate(savedInstanceState)
    }
}
