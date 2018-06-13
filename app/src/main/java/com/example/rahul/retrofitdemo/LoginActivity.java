package com.example.rahul.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rahul.retrofitdemo.ApiServices.ApiClient;
import com.example.rahul.retrofitdemo.ApiServices.ApiInterface;
import com.example.rahul.retrofitdemo.model.UserLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPass;
    Button btnLogin;
    String res;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail=findViewById(R.id.etEmail);
        etPass=findViewById(R.id.etPass);
        btnLogin=findViewById(R.id.btnLogin);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=etEmail.getText().toString();
                String pass=etPass.getText().toString();

                Log.d("email",email);
                Log.d("pass",pass);

                Call<UserLogin> call=apiInterface.performLogin(email,pass);
                call.enqueue(new Callback<UserLogin>() {
                    @Override
                    public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                        res=response.body().getResponse();
                        Toast.makeText(LoginActivity.this,res+"",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<UserLogin> call, Throwable t) {

                    }
                });
            }
        });

    }
}
