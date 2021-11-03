package com.agneshandayani.dicodingsubmission_github.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import static com.agneshandayani.dicodingsubmission_github.R.*;

public class SplashScreenActivity extends AppCompatActivity {
    private int waktu_loading=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent home=new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}