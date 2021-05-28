package com.example.jdros.tourbogota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Ruta extends AppCompatActivity {

    private TextView tv;
    private String cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);

        getSupportActionBar().hide();
        tv= (TextView) findViewById(R.id.textViewRuta);
        //El comando que recibe es "select * from Rutas wherePK_Ruta=#rura"
        cm=getIntent().getStringExtra("comando");
        tv.setText(cm);

    }
}
