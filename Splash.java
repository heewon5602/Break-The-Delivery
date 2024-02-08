package com.example.breakthedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Splash extends AppCompatActivity {
    ImageView imgLoading;
    
    //gif로 사용한다면 아래 코드 사용
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);

        imgLoading = (ImageView) findViewById(R.id.loading_icon);
        Glide.with(this).load(R.drawable.loading_icon).into(imgLoading);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(this, CustomerHome.class);
                startActivity(intent);
                finish();
            }
        }, 3000); //3초 동안 splash screen 보여주고 home으로 screen 이동

    }
    //customerHome에 관한 정보를 db에서 다 받아오면 해당 UI로 넘기는 코드 필요
}
