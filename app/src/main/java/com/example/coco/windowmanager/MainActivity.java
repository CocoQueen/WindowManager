package com.example.coco.windowmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view) {
        mTv = new TextView(this);
        mTv.setText("hello");
        ManagerUtils.getInstance().showManager(this, mTv);

    }

    public void serviceClick(View view) {
        startService(new Intent(this, MyService.class));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            ManagerUtils.getInstance().reset();
        return super.onKeyDown(keyCode, event);
    }
}
