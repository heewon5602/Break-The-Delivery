/*Application의 첫 화면(로그인, 회원가입 선택)*/

package com.example.breakthedelivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button signIn; //SignIn UI로 넘어가는 버튼
    Button signUp; //TypeSelection UI로 넘어가 type선택을 도와줌 (계정생성 버튼)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        signIn = findViewById(R.id.signIn); //SignIn UI로 향하는 button 'signIn'의 id 가져옴
        signUp = findViewById(R.id.signUp); //TypeSelection으로 향하는 button 'signUp'의 id 가져옴

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TypeSelection.class);
                startActivity(intent);
            }
        });
    }
}