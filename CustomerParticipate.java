package com.example.breakthedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerParticipate extends AppCompatActivity {
    ImageButton home_button; //하단바의 홈 버튼
    ImageButton group_button; //하단바의 참여 버튼
    ImageButton delivery_button; //하단바의 배달 버튼
    ImageButton profile_button; //하단바의 마이페이지 버튼
    ImageButton btnCart; //상단바의 장바구니 버튼
    private TextView tv2; //'현재 참여 인원/총 참여 가능 인원'
    private TextView tv3; //'현재 참여 인원/총 참여 가능 인원'
    private TextView tv4; //'현재 참여 인원/총 참여 가능 인원'
    private Button button_participate2; //참여하기 버튼
    private Button button_participate3; //참여하기 버튼
    private Button button_participate4; //참여하기 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_participate);

        home_button = (ImageButton)findViewById(R.id.home_button);
        group_button = (ImageButton)findViewById(R.id.group_button);
        delivery_button = (ImageButton)findViewById(R.id.delivery_button);
        profile_button = (ImageButton)findViewById(R.id.profile_button);
        btnCart = (ImageButton) findViewById(R.id.btnCart);
        tv2 = (TextView)findViewById(R.id.tv2);
        int now2 = 1;
        int all2 = 0; //임시로 0으로 해둠(db에서 가져와야함)
        tv2.setText(now2+"/"+all2);
        tv3 = (TextView)findViewById(R.id.tv3);
        int now3 = 1;
        int all3 = 0; //임시
        tv3.setText(now3 +"/"+all3);
        tv4 = (TextView)findViewById(R.id.tv4);
        int now4 = 1;
        int all4 = 0; //임시
        tv4.setText(now4+"/"+all4);
        button_participate2 = (Button)findViewById(R.id.button_participate2);
        button_participate3 = (Button)findViewById(R.id.button_participate3);
        button_participate4 = (Button)findViewById(R.id.button_participate4);

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
                group_button.setEnabled(false);
            }
        }); //현재 participate screen 노출 중이므로, 비활성화시킴

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

        /*장바구니 버튼*/
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerCart.class);
                startActivity(intent);
            }
        });

        /*참여하기 버튼 눌렀을 때*/
        button_participate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (now2 == all2) {
                    Toast.makeText(CustomerParticipate.this, "인원 모집이 마감되었습니다. 다른 참여방을 찾아주세요.", Toast.LENGTH_LONG).show();
                    // 참여 가능 인원 수와 참여 인원 수가 동일해지면 버튼 비활성화됨
                } else{
                    if (button_participate2.getText() == "참여") {
                        now2++;
                        tv2.setText(now2 +"/"+all2);
                        button_participate2.setText("참여 취소");
                        Toast.makeText(CustomerParticipate.this, "참여되었습니다", Toast.LENGTH_SHORT).show();
                    } //참여 버튼 클릭 : 참여 인원 수 증가, 버튼 텍스트 변경, 토스트 메시지 출력
                    else {
                        now2--;
                        tv2.setText(now2+"/"+all2);
                        button_participate2.setText("참여");
                        Toast.makeText(CustomerParticipate.this, "참여 취소되었습니다", Toast.LENGTH_SHORT).show();
                    } //참여 취소 버튼 클릭 : 참여 인원 수 감소, 버튼 텍스트 변경, 토스트 메시지 출력
                }
            }
        });

        button_participate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (now3 == all3) {
                    Toast.makeText(CustomerParticipate.this, "인원 모집이 마감되었습니다. 다른 참여방을 찾아주세요.", Toast.LENGTH_LONG).show();
                    // 참여 가능 인원 수와 참여 인원 수가 동일해지면 버튼 비활성화됨
                } else{
                    if (button_participate3.getText() == "참여") {
                        now3++;
                        tv3.setText(now3 +"/"+all3);
                        button_participate3.setText("참여 취소");
                        Toast.makeText(CustomerParticipate.this, "참여되었습니다", Toast.LENGTH_SHORT).show();
                    } //참여 버튼 클릭 : 참여 인원 수 증가, 버튼 텍스트 변경, 토스트 메시지 출력
                    else {
                        now3--;
                        tv3.setText(now3+"/"+all3);
                        button_participate2.setText("참여");
                        Toast.makeText(CustomerParticipate.this, "참여 취소되었습니다", Toast.LENGTH_SHORT).show();
                    } //참여 취소 버튼 클릭 : 참여 인원 수 감소, 버튼 텍스트 변경, 토스트 메시지 출력
                }
            }
        });

        button_participate4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (now4 == all4) {
                    Toast.makeText(CustomerParticipate.this, "인원 모집이 마감되었습니다. 다른 참여방을 찾아주세요.", Toast.LENGTH_LONG).show();
                    // 참여 가능 인원 수와 참여 인원 수가 동일해지면 버튼 비활성화됨
                } else{
                    if (button_participate4.getText() == "참여") {
                        now4++;
                        tv4.setText(now4 +"/"+all4);
                        button_participate3.setText("참여 취소");
                        Toast.makeText(CustomerParticipate.this, "참여되었습니다", Toast.LENGTH_SHORT).show();
                    } //참여 버튼 클릭 : 참여 인원 수 증가, 버튼 텍스트 변경, 토스트 메시지 출력
                    else {
                        now4--;
                        tv4.setText(now4+"/"+all4);
                        button_participate4.setText("참여");
                        Toast.makeText(CustomerParticipate.this, "참여 취소되었습니다", Toast.LENGTH_SHORT).show();
                    } //참여 취소 버튼 클릭 : 참여 인원 수 감소, 버튼 텍스트 변경, 토스트 메시지 출력
                }
            }
        });
    }

}
