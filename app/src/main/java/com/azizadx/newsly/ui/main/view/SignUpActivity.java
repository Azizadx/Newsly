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

import java.util.regex.Pattern;

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
        String usernameText = username.getText().toString();
        String emailText = email.getText().toString();
        String passText = pass.getText().toString();
        String repeatPassText = repeatPass.getText().toString();

        // Empty Input
        if (usernameText.isEmpty() || emailText.isEmpty()
                || passText.isEmpty()
                || repeatPassText.isEmpty()) {
            if (usernameText.isEmpty()) username.setError("Username is required");
            if (emailText.isEmpty()) email.setError("Email is required");
            if (passText.isEmpty()) pass.setError("Password is required");
            if (repeatPassText.isEmpty()) repeatPass.setError("Repeat Password is required");
            return;
        }

        // Check Email Pattern, Password Length, Password Match
       final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                        Pattern.CASE_INSENSITIVE);
        if (!passText.equals(repeatPassText) ||
                !VALID_EMAIL_ADDRESS_REGEX.matcher(emailText).find() ||
                passText.length() < 6) {
            if (!VALID_EMAIL_ADDRESS_REGEX.matcher(emailText).find())
                email.setError("Invalid Email.");
            if (!passText.equals(repeatPassText))
                repeatPass.setError("Please make sure your password match.");
            if (passText.length() < 6)
                pass.setError("Password must be >= 6 characters.");
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