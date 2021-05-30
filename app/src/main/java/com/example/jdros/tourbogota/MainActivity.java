package com.example.jdros.tourbogota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
    }

    public void pasar(View view){
        Intent intent = new Intent(getApplicationContext(),menuRutas.class);
        startActivity(intent);
    }
}
