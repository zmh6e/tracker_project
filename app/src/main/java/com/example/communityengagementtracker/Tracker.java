package com.example.communityengagementtracker;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.communityengagementtracker.data.LoginDataSource;
import com.example.communityengagementtracker.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tracker extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private LoginDataSource dataSource;
    TextView date;
    TextView StartTime;
    TextView EndTime;
    TextView Location;
    TextView Agency;
    TextView StudentName;
    TextView PartnerName;
    TextView Comments;

    Button submitButton;

    Button logoutButton;

EditText inputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        date=(TextView) findViewById(R.id.Date);
        StartTime=(TextView) findViewById(R.id.StartTime);
        EndTime=(TextView) findViewById(R.id.EndTime);
        Location=(TextView) findViewById(R.id.Location);
        Agency=(TextView) findViewById(R.id.Agency);
        StudentName=(TextView) findViewById(R.id.StudentName);
        PartnerName=(TextView) findViewById(R.id.PartnerName);
        Comments=(TextView) findViewById(R.id.Comments);

        logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                logout();
            }
        });
    }
    private void logout() {
        Intent logoutIntent = new Intent(this, LoginActivity.class);
        startActivity(logoutIntent);
        mAuth.signOut();
        Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show();
    }
}