package com.gyant.sdksamplejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.gyant.gyantchatsdk.GyantChat;

public class DisplayGyantViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_gyant_view);

        GyantChat gyantChat = new GyantChat();

        gyantChat.gyantChatInit("client_id",  "patient_id", true);

        View gyantView = gyantChat.gyantChatView(this, getLifecycle());

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        frameLayout.addView(gyantView);
    }


}
