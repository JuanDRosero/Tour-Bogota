package com.example.jdros.tourbogota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menuRutas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__rutas);

        getSupportActionBar().hide();
    }

    public void pasarActivity(View view){
        String comando="Ruta1";
        switch (view.getId()){
            case R.id.button1:
                comando="Ruta1";
                break;
            case R.id.button2:
                comando="Ruta2";
                break;

            case R.id.button3:
                comando="Ruta3";
                break;
        }

        Intent intent = new Intent(this,Ruta.class);
        intent.putExtra("comando",comando);
        startActivity(intent);
    }
}
