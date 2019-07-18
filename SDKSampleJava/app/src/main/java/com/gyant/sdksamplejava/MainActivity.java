package com.gyant.sdksamplejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.gyant.gyantchatsdk.GyantChat;
import com.gyant.gyantchatsdk.GyantChatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void changeToFragmentPage(View view) {
        Intent intent = new Intent(this, DisplayFragmentActivity.class);
        startActivity(intent);
    }
    public void changeToViewPage(View view) {
        Intent intent = new Intent(this, DisplayGyantViewActivity.class);
        startActivity(intent);
    }
    public void changeToActivityPage(View view) {
        Intent intent = new Intent(this, DisplayGyantChatActivity.class);
        startActivity(intent);
    }
}
