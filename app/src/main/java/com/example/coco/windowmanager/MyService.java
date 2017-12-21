package com.example.coco.windowmanager;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by coco on 2017/12/21.
 */

public class MyService extends Service {
    private static final String TAG = "MyService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: hehe");
        TextView mTv = new TextView(getApplicationContext());
        mTv.setText("你好啊");
        mTv.setTextColor(Color.BLUE);

        ManagerUtils.getInstance().showManager(getApplicationContext(), mTv);
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5000);
                ManagerUtils.getInstance().reset();
                stopSelf();
            }
        }).start();
    }
}
