package com.gyant.sdksamplejava;

import android.os.Bundle;

import com.gyant.gyantchatsdk.GyantChat;
import com.gyant.gyantchatsdk.GyantChatActivity;

public class DisplayGyantChatActivity extends GyantChatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //gyantChatInit should be called before onCreate
        GyantChat.getInstance()
                .clientId("client_id")
                .patientId("patient_id").start();

        super.onCreate(savedInstanceState);
    }
}
