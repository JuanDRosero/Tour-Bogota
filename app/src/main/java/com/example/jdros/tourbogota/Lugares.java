package com.example.jdros.tourbogota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Lugares extends AppCompatActivity {
    private TextView tvNombre,tvDescripcion;
    private ImageView iv;
    private String comandoResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        getSupportActionBar().hide();

        tvNombre= (TextView) findViewById(R.id.textViewNombreL);
        tvDescripcion= (TextView) findViewById(R.id.textViewDesL);
        iv=(ImageView) findViewById(R.id.imageView);
        comandoResult=getIntent().getStringExtra("comando");
        tvNombre.setText(comandoResult);
    }
}
