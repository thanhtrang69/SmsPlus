package com.example.trang.smsplus;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Trang on 4/7/2017.
 */

public class SmsReplierView extends LinearLayout implements View.OnClickListener, SmartEditText.onBackPressListner {
    private SmartEditText edtMessge;
    private Handler handler;

    public SmsReplierView(Context context) {
        super(context);
        this.handler = handler;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_sms_replier, this);
        inittializeComponents();
    }

    private void inittializeComponents() {
        edtMessge = (SmartEditText) findViewById(R.id.ed_tra_loi);
        edtMessge.setOnClickListener(this);
        edtMessge.setOnBackPressListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ed_tra_loi:
                handler.sendEmptyMessage(SmsReceiver.MESSAGE_FOCUS_VIEW);
                break;
            default:
                break;

        }
    }

    @Override
    public void onBackPress() {
        handler.sendEmptyMessage(SmsReceiver.MESSAGE_NO_FOCUS_VIEW);
    }
}
