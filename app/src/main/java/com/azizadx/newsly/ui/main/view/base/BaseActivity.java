package com.azizadx.newsly.ui.main.view.base;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class BaseActivity extends AppCompatActivity {
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
    }

    public void signUp(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
            if(task.isSuccessful()) {
                Toast.makeText(BaseActivity.this, "Added User", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(this, .class);
//                    startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Failed: " + task.getException(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void signIn(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if(task.isSuccessful()) {
                        Toast.makeText(BaseActivity.this, "SignedIn User", Toast.LENGTH_SHORT).show();
//                           Intent intent = new Intent(this, .class);
//                           startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Failed: " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // TODO: add all the other firebase functions
}