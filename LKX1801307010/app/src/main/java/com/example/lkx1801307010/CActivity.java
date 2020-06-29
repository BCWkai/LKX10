package com.example.lkx1801307010;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CActivity extends AppCompatActivity {
    private static final  String TAG="CActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        Intent intent = getIntent();
        Log.i(TAG,"——— intent:"+intent);
        Uri data = intent.getData();
        Log.i(TAG,"——— intent:data " + data);

        TextView webTV= findViewById(R.id.txt_Dial);
        webTV.setText(data.toString());
    }
}
