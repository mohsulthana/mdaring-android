package com.e.mdaring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class Dashboard extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextView user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user_name       = (TextView) findViewById(R.id.user_name);

        if (user != null) {
            String nama     = user.getEmail();
            user_name.setText(nama);

            boolean emailVerified   = user.isEmailVerified();
        }
    }
}
