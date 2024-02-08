package com.example.breakthedelivery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerParticipateStatus extends AppCompatActivity {
    public ArrayList<String> arrayParticipateRoom; //참여를 위해 만들어진 방들의 리스트

    public ListView participateRoom;
    private Context context;
    private RecyclerView.Adapter adapter;

    ImageButton home_button; //하단바의 홈 버튼
    ImageButton group_button; //하단바의 참여 버튼
    ImageButton delivery_button; //하단바의 배달 버튼
    ImageButton profile_button; //하단바의 마이페이지 버튼
    ImageButton btnCart; //상단바의 장바구니 버튼
    EditText edtSearch; //검색어를 입력할 검색창
    private TextView tv1_1; //'현재 참여 인원/총 참여 가능 인원'
    private TextView tv; // '현재 참여 인원/총 참여 가능 인원'
    private Button button_participate1_1; //참여하기 버튼
    private Button button_participate; //참여하기 버튼


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_participate_status);
        this.context = getApplicationContext();

        home_button = (ImageButton)findViewById(R.id.home_button);
        group_button = (ImageButton)findViewById(R.id.group_button);
        delivery_button = (ImageButton)findViewById(R.id.delivery_button);
        profile_button = (ImageButton)findViewById(R.id.profile_button);
        btnCart = (ImageButton) findViewById(R.id.btnCart);
        edtSearch = (EditText) findViewById(R.id.Search); //xml에서 search 라는 id를 가진 EditText layout 가져오기
        tv1_1 = (TextView)findViewById(R.id.tv1_1);
        int now2 = 1;
        int all2 = 0; //임시로 0으로 해둠(db에서 가져와야함)
        tv1_1.setText(now1_1+"/"+all1_1);
        tv = (TextView)findViewById(R.id.tv);
        int now = 1;
        int all = 0; //임시
        tv.setText(now +"/"+all);
        button_participate1_1 = (Button)findViewById(R.id.button_participate1_1);
        button_participate = (Button)findViewById(R.id.button_participate);

        /*참여 버튼*/
        button_participate1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (now1_1 == all1_1) {
                    Toast.makeText(CustomerParticipateStatus.this, "인원 모집이 마감되었습니다. 다른 참여방을 찾아주세요.", Toast.LENGTH_LONG).show();
                    // 참여 가능 인원 수와 참여 인원 수가 동일해지면 버튼 비활성화됨
                } else{
                    if (button_participate1_1.getText() == "참여") {
                        now1_1++;
                        tv1_1.setText(now1_1 +"/"+all1_1);
                        button_participate1_1.setText("참여 취소");
                        Toast.makeText(CustomerParticipateStatus.this, "참여되었습니다", Toast.LENGTH_SHORT).show();
                    } //참여 버튼 클릭 : 참여 인원 수 증가, 버튼 텍스트 변경, 토스트 메시지 출력
                    else {
                        now1_1--;
                        tv1_1.setText(now1_1+"/"+all1_1);
                        button_participate1_1.setText("참여");
                        Toast.makeText(CustomerParticipateStatus.this, "참여 취소되었습니다", Toast.LENGTH_SHORT).show();
                    } //참여 취소 버튼 클릭 : 참여 인원 수 감소, 버튼 텍스트 변경, 토스트 메시지 출력
                }
            }
        });

        button_participate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (now == all) {
                    Toast.makeText(CustomerParticipateStatus.this, "인원 모집이 마감되었습니다. 다른 참여방을 찾아주세요.", Toast.LENGTH_LONG).show();
                    // 참여 가능 인원 수와 참여 인원 수가 동일해지면 버튼 비활성화됨
                } else{
                    if (button_participate.getText() == "참여") {
                        now++;
                        tv1_1.setText(now +"/"+all);
                        button_participate.setText("참여 취소");
                        Toast.makeText(CustomerParticipateStatus.this, "참여되었습니다", Toast.LENGTH_SHORT).show();
                    } //참여 버튼 클릭 : 참여 인원 수 증가, 버튼 텍스트 변경, 토스트 메시지 출력
                    else {
                        now--;
                        tv1_1.setText(now+"/"+all);
                        button_participate.setText("참여");
                        Toast.makeText(CustomerParticipateStatus.this, "참여 취소되었습니다", Toast.LENGTH_SHORT).show();
                    } //참여 취소 버튼 클릭 : 참여 인원 수 감소, 버튼 텍스트 변경, 토스트 메시지 출력
                }
            }
        });

        /*하단바 메뉴 버튼*/
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), CustomerHome.class);
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
    }
    }