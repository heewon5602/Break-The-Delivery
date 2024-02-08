/*Customer의 Mypage UI*/
package com.example.breakthedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CustomerMyPage extends AppCompatActivity {
    Button btnParticipate; //참여현황
    Button btnHistory; //주문내역
    Button btnSavings; //절약현황
    Button btnConvert; //계정전환
    ImageButton home_button; //하단바의 홈 버튼
    ImageButton group_button; //하단바의 참여 버튼
    ImageButton delivery_button; //하단바의 배달 버튼
    ImageButton profile_button; //하단바의 마이페이지 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_mypage);
        btnParticipate = findViewById(R.id.btnParticipate);
        btnHistory = findViewById(R.id.btnHistory);
        btnSavings = findViewById(R.id.btnSavings);
        btnConvert = findViewById(R.id.btnConvert);
        home_button = (ImageButton)findViewById(R.id.home_button);
        group_button = (ImageButton)findViewById(R.id.group_button);
        delivery_button = (ImageButton)findViewById(R.id.delivery_button);
        profile_button = (ImageButton)findViewById(R.id.profile_button);

        btnParticipate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext().ParticipateStatus.class);
                startActivity(intent);
            }
        }); //버튼을 누르면 참여현황(ParticipateStauts) UI로 이동

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext().HistoryOrder.class);
                startActivity(intent);
            }
        }); //버튼을 누르면 주문내역(History Order)UI로 이동

        btnSavings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext().MySavings.class);
                startActivity(intent);
            }
        }); //버튼을 누르면 절약현황(MySavings) UI로 이동

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext().ConvertAccount.class);
                startActivity(intent);
            }
        }); //버튼을 누르면 계정전환(ConvertAccount) UI로 이동

        /*하단바 버튼*/
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerHome);
                startActivity(intent);
            }
        }); //현재 Home screen 노출 중이므로, 비활성화시킴

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
                profile_button.setEnabled(false);
            }
        });
    }
}