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

import java.util.regex.Pattern;

public class SignInActivity extends BaseActivity implements View.OnTouchListener {
    private EditText email, pass;

    //Button btnGoogleSignin = findViewById(R.id.btnGoogle);
    //Button btnFbSignin = findViewById(R.id.btnFb);

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
        String emailText = email.getText().toString();
        String passText = pass.getText().toString();

        // Empty Input
        if (emailText.isEmpty() || passText.isEmpty()) {
            if (emailText.isEmpty()) email.setError("Email is required");
            if (passText.isEmpty()) pass.setError("Password is required");
            return;
        }
        // Check Email Pattern and Validity/Existence(already signed up before)?
        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                        Pattern.CASE_INSENSITIVE);
        if (!VALID_EMAIL_ADDRESS_REGEX.matcher(emailText).find()) {
            if (!VALID_EMAIL_ADDRESS_REGEX.matcher(emailText).find())
                email.setError("Invalid Email.");
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