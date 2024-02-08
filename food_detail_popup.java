package com.example.breakthedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class food_detail_popup extends CustomerStore{
    Button btnToCart; //장바구니 담기
    private TextView foodDetail; //음식에 대한 상세설명

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detail_popup);

        foodDetail = (TextView)findViewById(R.id.foodDetail);

        Intent intent = getIntent(); //intent 값 받아오기
        int detail = intent.getIntExtra("imgbtnID", 0);
        switch (detail){
            case 1:
                foodDetail.setText("음식1에 대한 상세 설명");
                break;
            case 2:
                foodDetail.setText("음식2에 대한 상세 설명");
                break;
            case 3:
                foodDetail.setText("음식3에 대한 상세 설명");
                break;
            default:
                foodDetail.setText("음식에 대한 상세 설명이 존재하지 않습니다.");
                break;
        }

        Button btnToCart = (Button)findViewById(R.id.btnToCart);

        btnToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ()
            }
        }); //장바구니에 메뉴 담김
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        //바깥레이어 클릭시 팝업 닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return true;
        }
        return false;
    }
}
