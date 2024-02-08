/*사용자의 유형(고객, 배달원, 가게주인) 선택창 (회원가입의 첫번째 단계)*/
package com.example.breakthedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TypeSelection extends AppCompatActivity {
    Button customer_select; //Customer button의 아이디
    Button deliverMan_select; //Delivery Man의 아이디
    Button storeOwner_select; //Store Owner의 아이디

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_select);

        customer_select = findViewById(R.id.customer_select); //CustomerCreate로 향하는 button 'customer'의 id 가져옴
        deliverMan_select = findViewById(R.id.deliverMan_select); //DeliveryCreate로 향하는 button 'delivery'의 id 가져옴
        storeOwner_select = findViewById(R.id.storeOwner_select); //StoreCreate로 향하는 button 'store'의 id 가져옴

        customer_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerCreate.class);
                startActivity(intent);
            }
        });

        deliverMan_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DeliveryCreate.class);
                startActivity(intent);
            }
        });

        storeOwner_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerCreate.class);
                startActivity(intent);
            }
        });
    }
}