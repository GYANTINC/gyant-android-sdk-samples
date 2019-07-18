package com.gyant.sdksamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.gyant.gyantchatsdk.GyantChat

class DisplayGyantViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_gyant_view)

        val gyanChat = GyantChat();
        gyanChat.gyantChatInit( "clientID",  "patientID", true);

        val gyantView = gyanChat.gyantChatView(this, lifecycle);
        val frame = findViewById(R.id.frame_layout) as FrameLayout

        frame.addView(gyantView);
    }
}
