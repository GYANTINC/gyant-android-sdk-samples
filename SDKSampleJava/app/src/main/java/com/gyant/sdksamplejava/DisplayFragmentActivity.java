package com.gyant.sdksamplejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.gyant.gyantchatsdk.GyantChat;

public class DisplayFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_fragment);

        GyantChat gyantChat = new GyantChat();

        gyantChat.gyantChatInit( "client_id",  "patient_id", true);


        Fragment frag = gyantChat.gyantChatFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout, frag,  BuildConfig.APPLICATION_ID + ".GyantFragment")
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
