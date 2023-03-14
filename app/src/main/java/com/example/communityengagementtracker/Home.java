package com.example.communityengagementtracker;

import static android.content.ContentValues.TAG;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communityengagementtracker.data.LoginDataSource;
import com.example.communityengagementtracker.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Home extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private LoginDataSource dataSource;
    Button  engagementButton;

    Button requestsButton;

    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        engagementButton = findViewById(R.id.engagementButton);
        engagementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                openEngagements();
            }
        });

        requestsButton = findViewById(R.id.requestsButton);
        requestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                openRequests();
            }
        });

        logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {logout();
            }
        });
    }
    private void openEngagements (){
        Intent engagementIntent = new Intent(this, Tracker.class);
        startActivity(engagementIntent);
    }
    private void openRequests (){
        Intent requestsIntent = new Intent(this, Requests.class);
        startActivity(requestsIntent);
    }

    private void logout() {
        Intent logoutIntent = new Intent(this, LoginActivity.class);
        startActivity(logoutIntent);
        mAuth.signOut();
        Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show();
    }
}


