package com.example.breakthedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerStore extends AppCompatActivity {

    ImageButton food1_1;
    ImageButton food1_2;
    ImageButton food1_3;

    Button btnJoin; //참여 버튼
    Button btnCreate; //참여방 생성 버튼
    ImageButton home_button; //하단바의 홈 버튼
    ImageButton group_button; //하단바의 참여 버튼
    ImageButton delivery_button; //하단바의 배달 버튼
    ImageButton profile_button; //하단바의 마이페이지 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_store);

        food1_1 = (ImageButton) findViewById(R.id.food1_1);
        food1_2 = (ImageButton) findViewById(R.id.food1_2);
        food1_3 = (ImageButton) findViewById(R.id.food1_3);
        btnJoin = (Button) findViewById(R.id.button_participate_store);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        home_button = (ImageButton)findViewById(R.id.home_button);
        group_button = (ImageButton)findViewById(R.id.group_button);
        delivery_button = (ImageButton)findViewById(R.id.delivery_button);
        profile_button = (ImageButton)findViewById(R.id.profile_button);
        
        /*하단바 버튼들의 기능*/
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

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CustomerStore.this, "참여되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //음식 버튼 터치 -> 음식에 대한 상세 설명 popup 노출
    public void food1_1(View view){
        Intent intent = new Intent(this, food_detail_popup.class);
        intent.putExtra("imgbtnID", "1");
        startActivity(intent);
    }

    public void food1_2(View view){
        Intent intent = new Intent(this, food_detail_popup.class);
        intent.putExtra("imgbtnID", "2");
        startActivity(intent);
    }

    public void food1_3(View view){
        Intent intent = new Intent(this, food_detail_popup.class);
        intent.putExtra("imgbtnID", "3");
        startActivity(intent);
    }

    public void btnCreate(View view){
        Intent intent = new Intent(this, CustomerMakeRoom.class);
        startActivity(intent);
    }
}
