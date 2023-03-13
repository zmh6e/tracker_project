package com.example.communityengagementtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Tracker extends AppCompatActivity {
    TextView date;
    TextView StartTime;
    TextView EndTime;
    TextView Location;
    TextView Agency;
    TextView StudentName;
    TextView PartnerName;
    TextView Comments;

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
    }
}