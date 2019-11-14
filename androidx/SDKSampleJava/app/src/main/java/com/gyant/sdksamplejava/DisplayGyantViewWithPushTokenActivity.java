package com.gyant.sdksamplejava;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.gyant.chat_sdk.GyantChat;
import com.gyant.chat_sdk.GyantOnPushTokenListener;
import com.gyant.chat_sdk.CompletionHandler;
import com.gyant.chat_sdk.GyantView;


public class DisplayGyantViewWithPushTokenActivity extends AppCompatActivity implements GyantOnPushTokenListener{
    GyantView gyantView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_gyant_view);

        GyantChat gyantChat = GyantChat.getInstance()
                .clientId("client_id")
                .patientId("patient_id")
                .setOnPushTokenListener(this)
                .isDev(true)
                .start();

        this.gyantView = gyantChat.createView(this, getLifecycle());

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        frameLayout.addView(gyantView);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        this.gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void getPushToken(CompletionHandler<String> callback){
        callback.onComplete("token123");
    }
}