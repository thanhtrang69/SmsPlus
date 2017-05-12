package com.example.trang.smsplus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // requesDrawOverlayPremistion(); su dung cho API  > = 23
    }

//    private void requestDrawOverlayPermission(){
//        if (Build.VERSION.SDK_INT>=23){
//            if (!Settings.canDrawOverlays(this)){
//                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
//                startActivityForResult(intent, REQUEST_CODE_OVERLAY_PERMISSION);
//            }
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_CODE_OVERLAY_PERMISSION){
//            if (Build.VERSION.SDK_INT >= 23){
//                if (!Settings.canDrawOverlays(this)){
//                    finish();
//                }
//            }
//        }
//    }
}
