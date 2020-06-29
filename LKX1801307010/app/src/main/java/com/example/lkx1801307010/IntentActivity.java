package com.example.lkx1801307010;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.view.View;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_web).setOnClickListener(this);
    }

            @Override
            public void onClick(View v){
            switch (v.getId()) {
                case R.id.btn_dial: {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:1801307010"));
                    startActivity(intent);
                }
                break;
                case R.id.btn_web: {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.baidu.com"));
                    startActivity(intent);
                }
                break;
                default:
                    break;
            }
        }
    }