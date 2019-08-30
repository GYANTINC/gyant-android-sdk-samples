package com.gyant.sdksamplejava;

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.gyant.gyantchatsdk.GyantChat;
import com.gyant.gyantchatsdk.GyantView;

import java.util.HashMap;
import java.util.Map;

public class DisplayGyantViewWithThemeActivity extends AppCompatActivity {

    GyantView gyantView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_gyant_view);

        Map botPalette = new HashMap<String, String>();
        botPalette.put("primaryColor1","ff0000");

        Map providerPalette = new HashMap<String, String>();
        botPalette.put("primaryColor1","00ff00");


        Map themeMap = new HashMap<String, Map<String, String>>();
        themeMap.put("bot", botPalette);
        themeMap.put("provider", providerPalette);

        GyantChat.start( "client_id",  "patient_id", true, themeMap);

        this.gyantView = GyantChat.creatView(this, getLifecycle());

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        frameLayout.addView(gyantView);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        this.gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

