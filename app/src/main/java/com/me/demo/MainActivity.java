package com.me.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.me.demo.presenter.DemoPresenter;
import com.me.demo.view.loginView;

public class MainActivity extends AppCompatActivity implements loginView {

    private EditText nameEdt;
    private EditText passwordEdt;

    private TextView resultTv;

    private DemoPresenter presenter = new DemoPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdt = (EditText) findViewById(R.id.name_edit_text);
        passwordEdt = (EditText) findViewById(R.id.password_edit_text);

        resultTv = (TextView) findViewById(R.id.result_text_view);

        Button checkBtn = (Button) findViewById(R.id.check_button);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLogin(nameEdt.getText().toString(), passwordEdt.getText().toString());
            }
        });
    }

    @Override
    public void onLoginResult(boolean status) {
        resultTv.setVisibility(View.VISIBLE);
        if (status) {
            resultTv.setTextColor(Color.GREEN);
            resultTv.setText(getString(R.string.case_correct));
        } else {
            resultTv.setTextColor(Color.RED);
            resultTv.setText(getString(R.string.case_error));
        }
    }

    @Override
    public void isNameValid(boolean status) {
        if (!status)
            nameEdt.setError(getString(R.string.name_require));
    }

    @Override
    public void isPasswordValid(boolean status) {
        if (!status)
            passwordEdt.setError(getString(R.string.password_require));
    }
}