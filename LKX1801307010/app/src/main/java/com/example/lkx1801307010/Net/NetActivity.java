package com.example.lkx1801307010.Net;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.example.lkx1801307010.Net.bean.VideoListResponse;
import com.example.lkx1801307010.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class NetActivity extends AppCompatActivity {
    private static final String TAG= NetActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
    }
        public void toJsonClick(View view) {
        String json = "{\n" +
                "  \"result\": \"0\",\n" +
                "  \"list\": [\n" +
                "    {\n" +
                "      \"title\": \"Big Wedding Day\",\n" +
                "      \"filePath\": \"http://ramedia.sinaapp.com/res/Video/BigWeddingDay.hlv\",\n" +
                "      \"thumbPath\": \"http://ramedia.sinaapp.com/res/Video/BigWeddingDay.png\",\n" +
                "      \"id\": \"2\n" +
                "    }\n" +
                "  ]\n" +
                "}";
            VideoListResponse videoListResponse = convertJsonToBean(json);

        }
    private VideoListResponse convertJsonToBean(String json){
        Gson gson = new Gson();
        VideoListResponse response = gson.fromJson(json ,VideoListResponse.class);
        return response;
    }

    public void toRequestNet(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String raUrl = "http://ramedia.sinaapp.com/videolist.json";
                try{
                    URL url = new URL(raUrl);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(10000);
                    urlConnection.connect();
                    int responseCode = urlConnection.getResponseCode();
                    Log.i(TAG,"—— responseCode:" + responseCode);

                    if(200 == responseCode){
                        InputStream inputStream = urlConnection.getInputStream();
                        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
                        String line = null;
                        do{
                            line = bf.readLine();
                            Log.i(TAG,"—— 服务器响应的数据:"+line);
                        } while (line != null);
                        inputStream.close();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }




}
