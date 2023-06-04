/*Customer을 위한 계정 생성 UI*/
package com.example.breakthedelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CustomerCreate extends AppCompatActivity {
    EditText customer_id; //Id 입력창
    EditText customer_pw; //password 입력창
    EditText customer_phoneNum; //Phone number 입력창
    Button btnNext;
    ProgressBar loadingBar;
    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    private static String URL_REGIST = "http://moblieigroup.dothome.co.kr/btd/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_customer);
        context = getApplicationContext();

        customer_id = findViewById(R.id.customer_id); //xml에서 editView 형태 Id의 아이디도 txtId라고 가정
        customer_pw = findViewById(R.id.customer_pw); //xml에서 editView 형태 Password의 아이디도 txtPassword라고 가정
        customer_phoneNum = findViewById(R.id.customer_phoneNum); //xml에서 editView 형태 Phone의 아이디도 txtPhone라고 가정
        btnNext = findViewById(R.id.button_next);
        //loadingBar = findViewById(R.id.loadingBar);

        Log.i("register", URL_REGIST);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regist();
                Toast.makeText(context, customer_id+"님, 계정 생성이 완료되었습니다.", duration).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void regist()
    {
        //loadingBar.setVisibility(View.VISIBLE);
        //btnNext.setVisibility(View.GONE);

        final String userid = this.customer_id.getText().toString().trim();
        final String password = this.customer_pw.getText().toString().trim();
        final String phoneNumber = this.customer_phoneNum.getText().toString().trim();
        final String type = "customer".trim();
        Log.i("register", "start");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                Log.i("register", "response");
                try {
                    Log.i("register", "try");
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    Log.i("register", jsonObject.toString());
                    if (success.equals("1"))
                    {
                        Toast.makeText(CustomerCreate.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(CustomerCreate.this, SignIn.class);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(CustomerCreate.this, "회원가입 도중 에러 발생 : " + e.toString(), Toast.LENGTH_SHORT).show();
                    //loadingBar.setVisibility(View.GONE);
                    btnNext.setVisibility(View.VISIBLE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("register", "onErrorResponse: " + error.getMessage());
                Toast.makeText(CustomerCreate.this, "회원가입 도중 에러 발생 : " + error.toString(), Toast.LENGTH_SHORT).show();
                //.setVisibility(View.GONE);
                btnNext.setVisibility(View.VISIBLE);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<>();
                params.put("userid", userid);
                params.put("password", password);
                params.put("phoneNumber", phoneNumber);
                params.put("type", type);
                return params;
            }
        };
        Log.i("register", "end");
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
