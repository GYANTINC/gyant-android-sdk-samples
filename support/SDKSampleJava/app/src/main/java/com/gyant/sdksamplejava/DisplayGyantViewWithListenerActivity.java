package com.gyant.sdksamplejava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.gyant.chat_sdk.CompletionHandler;
import com.gyant.chat_sdk.GyantChat;
import com.gyant.chat_sdk.GyantChatListener;
import com.gyant.chat_sdk.GyantView;

import java.util.Map;

public class DisplayGyantViewWithListenerActivity extends AppCompatActivity implements GyantChatListener {
    private GyantView gyantView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        GyantChat gyantChat = GyantChat.getInstance()
                .clientId("client_id")
                .listener(this)
                .isDev(true)
                .start();

        this.gyantView = gyantChat.createView(this, getLifecycle());

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        frameLayout.addView(gyantView);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onDiagnosis(Map diagnosis) {
        Log.d("GyantDiagnosis", diagnosis.toString());
    }

    @Override
    public void onMessage(String message) {
        Log.d("GyantMessage", message);
    }

    @Override
    public void getPushToken(CompletionHandler<String> callback){
        callback.onComplete("token123");
    }
}
