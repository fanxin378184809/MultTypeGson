package com.fanxin.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.github.fanxin.gsonhelper.gson.GsonHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.github.fanxin.gsonhelper.gson.GsonHelper.getGsonNotNull;

public class MainActivity extends AppCompatActivity {
    private String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        json = getJson();
    }

    public String getJson(){
        StringBuilder sb = new StringBuilder();
        try {
            InputStream in = getAssets().open("json2.json");
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = bf.readLine()) != null){
                sb.append(line);
            }
            in.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void onButtonClick(View view) {
        JsonData jsonData = GsonHelper.getGson().fromJson(json, JsonData.class);
        Log.e("aaa",jsonData.toString());
    }
}
