package com.e.mdaring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.mdaring.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {

    private static final String TAG = "SignUp";

    // Firebase Database
    FirebaseDatabase database;
    DatabaseReference users;

    // Firebase Authentication
    private FirebaseAuth mAuth;

    EditText editUsername, editPassword, editEmail;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Firebase Database
        database    = FirebaseDatabase.getInstance();
        users       = database.getReference("Users");

        // Firebase Authentication
        mAuth       = FirebaseAuth.getInstance();

        editUsername    = (EditText) findViewById(R.id.username);
        editEmail       = (EditText) findViewById(R.id.email);
        editPassword    = (EditText) findViewById(R.id.password);

        btnSignup       = (Button) findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });
    }

    private void SignUp() {
        String mail        = editEmail.getText().toString();
        String pass        = editPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(mail, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Account created", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUp.this, "Account failed created", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
