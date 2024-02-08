package com.example.breakthedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerOrderHistory extends AppCompatActivity {

    ImageButton home_button; //하단바의 홈 버튼
    ImageButton group_button; //하단바의 참여 버튼
    ImageButton delivery_button; //하단바의 배달 버튼
    ImageButton profile_button; //하단바의 마이페이지 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_order_history);

        home_button = (ImageButton)findViewById(R.id.home_button);
        group_button = (ImageButton)findViewById(R.id.group_button);
        delivery_button = (ImageButton)findViewById(R.id.delivery_button);
        profile_button = (ImageButton)findViewById(R.id.profile_button);

        /*하단바 메뉴 버튼들의 기능*/
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerHome.class);
                startActivity(intent);
            }
        });

        group_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerParticipate.class);
                startActivity(intent);
            }
        });

        delivery_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerMyDelivery.class);
                startActivity(intent);
            }
        });

        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerMyPage.class);
                startActivity(intent);
            }
        });
    }
}