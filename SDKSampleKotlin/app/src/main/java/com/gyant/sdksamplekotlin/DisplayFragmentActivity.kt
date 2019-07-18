package com.gyant.sdksamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gyant.gyantchatsdk.GyantChat

class DisplayFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val gyantChat = GyantChat();

        gyantChat.gyantChatInit( "clientID",  "patientID", true);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_fragment)

        val frag = gyantChat.gyantChatFragment();

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout, frag,  BuildConfig.APPLICATION_ID + ".GyantFragment")
            .commit();
    }
}
