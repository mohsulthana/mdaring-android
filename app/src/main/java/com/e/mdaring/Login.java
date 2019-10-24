package com.e.mdaring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username        = (EditText) findViewById(R.id.username);
        password        = (EditText) findViewById(R.id.password);
        btnLogin        = (Button) findViewById(R.id.btnLogin);
        mAuth           = FirebaseAuth.getInstance();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }
        });
    }

    private void SignIn() {
        String uname        = username.getText().toString();
        String pass         = password.getText().toString();

        mAuth.signInWithEmailAndPassword(uname, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Logged In", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Login.this, Dashboard.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(Login.this, "Account is not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
