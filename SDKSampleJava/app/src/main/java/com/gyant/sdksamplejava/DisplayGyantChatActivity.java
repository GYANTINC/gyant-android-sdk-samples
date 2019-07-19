package com.gyant.sdksamplejava;

import android.os.Bundle;

import com.gyant.gyantchatsdk.GyantChat;
import com.gyant.gyantchatsdk.GyantChatActivity;

public class DisplayGyantChatActivity extends GyantChatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //gyantChatInit should be called before onCreate
        GyantChat.start( "client_id",  "patient_id", true);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
