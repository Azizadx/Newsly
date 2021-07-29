package com.azizadx.newsly.ui.main.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.azizadx.newsly.R;
import com.azizadx.newsly.ui.main.view.base.BaseActivity;

public class SignInActivity extends BaseActivity implements View.OnTouchListener {
    private EditText email, pass;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.editTextEmail);
        pass = findViewById(R.id.editTextPassword);

        Button signInButton = findViewById(R.id.buttonSignIn);
        signInButton.setOnClickListener(view -> buttonSignIn());

        TextView signUpTextView = findViewById(R.id.textSignUp);
        signUpTextView.setOnTouchListener(this);
    }

    private void buttonSignIn() {
        if ( email.getText().toString().isEmpty()
                || pass.getText().toString().isEmpty()) {
            Toast.makeText(this, "Empty Input", Toast.LENGTH_SHORT).show();
            return;
        }
        signIn(email.getText().toString(), pass.getText().toString());
    }

    private void clickSignUp() {
       Intent intent = new Intent(this, SignUpActivity.class);
       startActivity(intent);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        clickSignUp();
        return false;
    }
}