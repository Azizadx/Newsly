package com.azizadx.newsly.ui.main.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.azizadx.newsly.R;
import com.azizadx.newsly.ui.main.view.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseUser;


public class ProfileActivity extends BaseActivity implements View.OnClickListener {
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // bind profile settings
        findViewById(R.id.textNotification).setOnClickListener(this);
        findViewById(R.id.textLanguage).setOnClickListener(this);
        findViewById(R.id.textChangePass).setOnClickListener(this);
        findViewById(R.id.textPrivacy).setOnClickListener(this);
        findViewById(R.id.textTC).setOnClickListener(this);
        findViewById(R.id.textSignOut).setOnClickListener(this);

        // Bottom Nav Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.navbarr);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bookmarks:
                    startActivity(new Intent(getApplicationContext()
                            , BookmarksEmptyStateActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.home:
                    startActivity(new Intent(getApplicationContext()
                            , MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.profile:
                    return true;
            }
            return false;
        });

        // load authenticated user's profile data
        user = getAuthUser();
        if (user != null) loadUserData();
    }

    private void loadUserData() {
        TextView profileName, profileEmail;
        ImageView profileAvatar;

        // bind user profile view
        profileAvatar = findViewById(R.id.profile_avatar);
        profileName = findViewById(R.id.profile_name);
        profileEmail = findViewById(R.id.profile_email);

        // assign value to view
        profileAvatar.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.ic_user));
        profileEmail.setText(user.getEmail());
        profileName.setText(user.getEmail().split("@")[0]);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.textLanguage) {
            showInfoDialog("Language", "Language...\n\nComing soon!\n");
        } else if (view.getId() == R.id.textChangePass) {
            showInfoDialog("Change Password", "Password Change Option...\n\nComing soon!\n");
        } else if (view.getId() == R.id.textPrivacy) {
            showInfoDialog("Privacy", "Your data is safe with us!" +
                    "\n\nWe will definitely NOT sell your data to a third party for our advantage!!!\n");
        } else if (view.getId() == R.id.textTC) {
            showInfoDialog("Terms and Conditions", "Our Terms and Conditions are simple and affordable!!!" +
                    "\n\nJust send us money when our employees' rents are due 🤗\n");
        } else if (view.getId() == R.id.textSignOut) {
            signOut();
        }
    }

    // profile settings dialog
    private void showInfoDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_info)
                .create()
                .show();
    }
}
