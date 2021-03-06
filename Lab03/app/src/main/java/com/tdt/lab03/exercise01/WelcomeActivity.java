package com.tdt.lab03.exercise01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tdt.lab03.R;

/**
 * Created by thChung on 3/2/2019.
 */

public class WelcomeActivity extends AppCompatActivity {
    private TextView tvMessage;
    private EditText edtName;
    private Button btnSaveAndQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initView();
        onActivityResult();
        handleEvents();
    }

    private void handleEvents() {
        btnSaveAndQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String studentName = edtName.getText().toString();
                intent.putExtra(MainActivity.USER_EMAIL_INTENT, studentName);
                setResult(MainActivity.SUCCESS_CODE, intent);
                finish();
            }
        });
    }

    private void onActivityResult() {
        String studentEmail = getIntent().getStringExtra(MainActivity.USER_NAME_INTENT);
        tvMessage.setText("Xin chào, " + studentEmail + ". Vui lòng nhập tên:");
    }

    private void initView() {
        tvMessage = findViewById(R.id.tvMessage);
        edtName = findViewById(R.id.edtName);
        btnSaveAndQuit = findViewById(R.id.btnSaveAndQuit);
    }
}
