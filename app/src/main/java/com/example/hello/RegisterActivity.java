package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hello.model.Account;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvUser,tvPass;
    private Button btCancel, btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_register);
        initView();
        btCancel.setOnClickListener(this);
        btRegister.setOnClickListener(this);
    }

    private void initView() {
        tvUser=findViewById(R.id.txtUsername);
        tvPass=findViewById(R.id.txtPassword);
        btCancel=findViewById(R.id.btnCancel);
        btRegister=findViewById(R.id.btnRegister);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancel:
                setResult(RESULT_CANCELED,null);
                finish();
                break;
            case R.id.btnRegister:
                Account acc=new Account(tvUser.getText().toString(),tvPass.getText().toString());
                Intent regIntent=new Intent();
                regIntent.putExtra("data", acc);
                setResult(RESULT_OK, regIntent);
                finish();
                break;
        }
    }
}