package com.azizadx.newsly.ui.main.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;

import androidx.appcompat.content.res.AppCompatResources;

import com.azizadx.newsly.R;
import com.azizadx.newsly.ui.main.view.base.BaseActivity;

public class SignUpActivity extends BaseActivity implements View.OnTouchListener  {
    private EditText username, email, pass, repeatPass;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.editTextUserName);
        email = findViewById(R.id.editTextEmail);
        pass = findViewById(R.id.editTextPassword);
        repeatPass = findViewById(R.id.editTextRepeatPassword);

        Button signUpButton = findViewById(R.id.buttonSignUp);
        signUpButton.setOnClickListener(view -> buttonSignUp());

        TextView signInTextView = findViewById(R.id.textSignIn);
        signInTextView.setOnTouchListener(this);
    }

    private void buttonSignUp() {
        if (username.getText().toString().isEmpty() || email.getText().toString().isEmpty()
                || pass.getText().toString().isEmpty()
                || repeatPass.getText().toString().isEmpty()) {
            Toast.makeText(this, "Empty Input", Toast.LENGTH_SHORT).show();
            return;
        }
        signUp(email.getText().toString(), pass.getText().toString());
    }

    private void clickSignIn() {
       // Toast.makeText(getApplicationContext(), "Go To SignIn", Toast.LENGTH_SHORT).show();
      Intent intent = new Intent(this, SignInActivity.class);
      startActivity(intent);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        clickSignIn();
        return false;
    }
}