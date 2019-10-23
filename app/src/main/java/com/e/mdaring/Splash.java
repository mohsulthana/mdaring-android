package com.e.mdaring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // redirect to welcome activity
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
        finish();
    }
}
