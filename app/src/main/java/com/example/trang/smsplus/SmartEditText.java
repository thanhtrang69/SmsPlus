package com.example.trang.smsplus;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;

/**
 * Created by Trang on 4/7/2017.
 */

public class SmartEditText extends AppCompatEditText {
    public onBackPressListner onBackPressListener;

    public void setOnBackPressListener(onBackPressListner Listener) {
        this.onBackPressListener =Listener;
    }

    public SmartEditText(Context context) {
        super(context);
    }

    public SmartEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SmartEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
           onBackPressListener.onBackPress();
        }
        return super.onKeyDown(keyCode, event);
    }

    public interface onBackPressListner {
        void onBackPress();
    }
}
