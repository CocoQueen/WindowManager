package com.example.coco.windowmanager;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by coco on 2017/12/21.
 */

public class ManagerUtils {
    public static ManagerUtils utils;
    WindowManager wm;
    View v;
    boolean isadded;

    public static ManagerUtils getInstance() {
        if (utils == null) {
            utils = new ManagerUtils();
        }
        return utils;
    }

    public void showManager(Context context, View v) {
        reset();
        this.v = v;
        wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = 200;
        params.height = 200;
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        params.x = 300;
        params.horizontalMargin = 0;
        isadded = true;
        wm.addView(v, params);

    }

    //重置manager
    public void reset() {
        if (v != null && wm != null && isadded) {
            wm.removeView(v);
            v = null;
            wm = null;
        }
    }
}
