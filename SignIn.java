/*로그인 화면*/
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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignIn extends AppCompatActivity {
    EditText customer_id;
    EditText customer_pw;
    Button button_next;
    ProgressBar loadingBar;
    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    private static String URL_LOGIN = "http://moblieigroup.dothome.co.kr/btd/login.php";

    String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        context = getApplicationContext();

        customer_id = findViewById(R.id.customer_id); //xml에서 editView 형태 Id의 아이디도 txtId라고 가정
        customer_pw = findViewById(R.id.customer_pw); //xml에서 editView 형태 Password의 아이디도 txtPassword라고 가정
        button_next = findViewById(R.id.button_next);
        loadingBar = findViewById(R.id.loadingBar);

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = customer_id.getText().toString().trim();
                String password = customer_pw.getText().toString().trim();

                if (!userid.isEmpty() || !password.isEmpty())
                {
                    Log.i("login", "loginStart");
                    login(userid, password);
                }
                else
                {
                    customer_id.setError("아이디를 입력해 주세요");
                    customer_pw.setError("비밀번호를 입력해 주세요");
                }
            }
        });

    }
    private void login(final String userid, final String password)
    {
        loadingBar.setVisibility(View.VISIBLE);
        button_next.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    Log.i("login", response);
                    JSONObject jsonObject = new JSONObject(response);
                    Log.i("login", jsonObject.toString());
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");

                    if (success.equals("1"))
                    {
                        for (int i = 0; i < jsonArray.length(); i++)
                        {
                            JSONObject object = jsonArray.getJSONObject(i);

                            String tUserid = object.getString("userid").trim();
                            String tPassword = object.getString("password").trim();
                            String tType = object.getString("type").trim();

                            switch (tType){
                                case "customer":
                                    Log.i("login", "customer");
                                    Toast.makeText(SignIn.this, "로그인 성공 손님", Toast.LENGTH_SHORT).show();
                                    Intent intentCustomer = new Intent(SignIn.this, CustomerHome.class);
                                    startActivity(intentCustomer);
                                    break;
                                case "delivery":
                                    Toast.makeText(SignIn.this, "로그인 성공 배달", Toast.LENGTH_SHORT).show();
                                    Intent intentDelivery = new Intent(SignIn.this, MainActivity.class);
                                    startActivity(intentDelivery);
                                    break;
                                case "store":
                                    Toast.makeText(SignIn.this, "로그인 성공 가게", Toast.LENGTH_SHORT).show();
                                    Intent intentStore = new Intent(SignIn.this, MainActivity.class);
                                    startActivity(intentStore);
                                    break;
                                default:
                                    Toast.makeText(context, "아무 모드도 아닙니다.", duration).show();

                                    Toast.makeText(context, customer_id+"님, 이 로그인하셨습니다.", duration).show();
                            }
                            loadingBar.setVisibility(View.GONE);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    loadingBar.setVisibility(View.GONE);
                    button_next.setVisibility(View.VISIBLE);
                    Toast.makeText(SignIn.this, "에러1 : " + e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                loadingBar.setVisibility(View.GONE);
                button_next.setVisibility(View.VISIBLE);
                Toast.makeText(SignIn.this, "에러2 : " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<>();
                params.put("userid", userid);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}