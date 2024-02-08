package com.example.breakthedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerSavings extends AppCompatActivity {
    TextView txtTodayDate; //'ex) 30 March'
    TextView txtYesterdayDate; //'ex) 30 March'
    TextView txtMonth; //'MONTH TOTAL'이라는 텍스트의 id 임의 설정
    ImageButton home_button; //하단바의 홈 버튼
    ImageButton group_button; //하단바의 참여 버튼
    ImageButton delivery_button; //하단바의 배달 버튼
    ImageButton profile_button; //하단바의 마이페이지 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_savings);

        txtTodayDate = (TextView) findViewById(R.id.txtTodayDate);
        txtYesterdayDate = (TextView) findViewById(R.id.txtYesterdayDate);
        txtMonth = (TextView) findViewById(R.id.txtMonth);
        home_button = (ImageButton)findViewById(R.id.home_button);
        group_button = (ImageButton)findViewById(R.id.group_button);
        delivery_button = (ImageButton)findViewById(R.id.delivery_button);
        profile_button = (ImageButton)findViewById(R.id.profile_button);

        dateFormat();

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
    public void dateFormat() {
        long now = System.currentTimeMillis();// 1970년 1월 1일부터 몇 밀리세컨드가 지났는지를 반환함
        Date date = new Date(now);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");//형식 지정
        String TodayMonth = simpleDateFormat.format(date);
        simpleDateFormat = new SimpleDateFormat("d");//형식 지정
        String TodayDate = simpleDateFormat.format(date);

        //날짜 출력하기
        String month; //ex)1월: January로 출력하는 switch 조건문에 사용

        //오늘 날짜 출력하기 (ex. 30 March)
        switch (TodayMonth) {
            case "01":
                month = "January";
                break;
            case "02":
                month = "Feburary";
                break;
            case "03":
                month = "March";
                break;
            case "04":
                month = "April";
                break;
            case "05":
                month = "May";
                break;
            case "06":
                month = "June";
                break;
            case "07":
                month = "July";
                break;
            case "08":
                month = "August";
                break;
            case "09":
                month = "September";
                break;
            case "10":
                month = "October";
                break;
            case "11":
                month = "November";
                break;
            case "12":
                month = "December";
                break;
            default:
                month = "month";
                break;
        }
        txtTodayDate.setText(TodayDate + "\r\n" + month);
        txtMonth.setText(month+" TOTAL");

        //어제 날짜 계산 및 출력하기 (ex. 30 March)
        int d = Integer.parseInt(TodayDate);
        int yesterdayDate = d - 1; //yesterdayDate 계산을 위한 format
        int newD = 1; //m: 월, d: 일, newD:어제날짜 게산 시, d-1=0인 경우의 조건문에 사용

        if (yesterdayDate == 0) {
            if (month == "January") {
                newD = 31;
                month = "December";
            } else if (month == "Feburary") {
                newD = 31;
                month = "January";
            } else if (month == "March") {
                newD = 28;
                month = "Feburary";
            } else if (month == "April") {
                newD = 31;
                month = "March";
            } else if (month == "May") {
                newD = 30;
                month = "April";
            } else if (month == "June") {
                newD = 31;
                month = "May";
            } else if (month == "July") {
                newD = 30;
                month = "June";
            } else if (month == "August") {
                newD = 31;
                month = "July";
            } else if (month == "September") {
                newD = 31;
                month = "August";
            } else if (month == "October") {
                newD = 30;
                month = "September";
            } else if (month == "November") {
                newD = 31;
                month = "October";
            } else {
                newD = 30;
                month = "November";
            }
            txtYesterdayDate.setText(newD + "\r\n" + month);
        } else
            txtYesterdayDate.setText(yesterdayDate + "\r\n" + month);

        return;
    }
}