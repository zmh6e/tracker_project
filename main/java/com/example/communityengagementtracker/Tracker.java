package com.example.communityengagementtracker;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communityengagementtracker.data.LoginDataSource;
import com.example.communityengagementtracker.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    EditText date, StartTime, EndTime, Location, Agency, StudentName, PartnerName, Comments;

    Button submitButton, logoutButton;
    DatabaseReference reff;
    Engagements engagements;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        date=(EditText) findViewById(R.id.editTextDate);
        StartTime=(EditText) findViewById(R.id.editTextTime);
        EndTime=(EditText) findViewById(R.id.editTextTime2);
        Location=(EditText) findViewById(R.id.editTextLocation);
        Agency=(EditText) findViewById(R.id.editTextAgency);
        StudentName=(EditText) findViewById(R.id.editTextStudentName);
        PartnerName=(EditText) findViewById(R.id.editTextPartnerName);
        Comments=(EditText) findViewById(R.id.editTextComments);

        engagements = new Engagements();
        reff = FirebaseDatabase.getInstance().getReference().child("Engagements");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxid = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int eDate = Integer.parseInt(date.getText().toString().trim());
                int eStart = Integer.parseInt(StartTime.getText().toString().trim());
                int eEnd = Integer.parseInt(EndTime.getText().toString().trim());

                engagements.setName(StudentName.getText().toString().trim());
                engagements.setPartner(PartnerName.getText().toString().trim());
                engagements.setAgency(Agency.getText().toString().trim());
                engagements.setLocation(Location.getText().toString().trim());
                engagements.setComments(Comments.getText().toString().trim());
                engagements.setDate(eDate);
                engagements.setStartTime(eStart);
                engagements.setEndTime(eEnd);
                reff.child(String.valueOf(maxid+1)).setValue(engagements);
                Toast.makeText(Tracker.this,"Engagement Saved",Toast.LENGTH_LONG).show();
            }
        });


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