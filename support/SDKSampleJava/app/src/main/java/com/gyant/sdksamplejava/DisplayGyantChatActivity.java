package com.gyant.sdksamplejava;

import android.os.Bundle;

import com.gyant.chat_sdk.GyantChat;
import com.gyant.chat_sdk.GyantChatActivity;

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
