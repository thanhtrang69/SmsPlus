package com.example.trang.smsplus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Trang on 4/7/2017.
 */

public class SmsReceiver extends BroadcastReceiver {
    public static final int MESSAGE_FOCUS_VIEW = 100;
    public static final int MESSAGE_NO_FOCUS_VIEW = 101;
    private SmsReplierView smsReplierView;
    private WindowManager windowManager;
    private WindowManager.LayoutParams params;
    private Handler handler;

    @Override
    public void onReceive(Context context, Intent intent) {
        showSmsRelierView(context);
        enableFlyingSmsReplierView();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case MESSAGE_FOCUS_VIEW:
                        params.flags = params.flags & ~WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                        windowManager.updateViewLayout(smsReplierView, params);
                        break;

                    case MESSAGE_NO_FOCUS_VIEW:
                        params.flags = params.flags | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                        windowManager.updateViewLayout(smsReplierView, params);
                        break;

                    default:
                        break;
                }

            }


        };
    }

    public void showSmsRelierView(Context mContext) {
        windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        smsReplierView = new SmsReplierView(mContext);
        params = new WindowManager.LayoutParams();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        params.flags = params.flags | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        params.type = WindowManager.LayoutParams.TYPE_PHONE;
        params.format = PixelFormat.TRANSPARENT;
        windowManager.addView(smsReplierView, params);
    }

    private void enableFlyingSmsReplierView() {
        smsReplierView.setOnTouchListener(new View.OnTouchListener() {
            float xTouch = 0.0F;
            float yTouch = 0.0F;
            float xView = 0.0F;
            float yView = 0.0F;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xTouch = event.getRawX();
                        yTouch = event.getRawY();

                        xView = params.x;
                        yView = params.y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float dentaX = event.getRawX() - xTouch;
                        float dentaY = event.getRawY() - yTouch;


                        params.x = (int) (xView + dentaX);
                        params.y = (int) (yView + dentaY);

                        windowManager.updateViewLayout(smsReplierView, params);
                        break;

                    default:
                        break;
                }
                return true;
            }
        });
    }

    private void removeSmsReplierView() {
        windowManager.removeView(smsReplierView);
        smsReplierView = null;
    }
}
