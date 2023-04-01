package com.example.communityengagementtracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {
    private EditText emailEditText;
    private Button submitButton;
    private ProgressBar progressBar;

    FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_activity);

        emailEditText = (EditText) findViewById(R.id.email);
        submitButton = (Button) findViewById(R.id.submitButton);

        mAuth = FirebaseAuth.getInstance();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

    }

    private void resetPassword(){
        String email = emailEditText.getText().toString().trim();
        //if the email field is empty raise an error
        if(email.isEmpty()){
            emailEditText.setError("Email is required.");
            emailEditText.requestFocus();
            return;
        }
        //if the email entered is invalid raise an error
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Please provide a valid email.");
            emailEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                //if the email was sent successfully, inform the user
                if(task.isSuccessful()){
                    Toast.makeText(ResetPassword.this, "Check your email to reset your password.", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ResetPassword.this, "Unexpected error occurred, try again.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
