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
        String comando="select * from Rutas where PK_Rutas=";
        switch (view.getId()){
            case R.id.button1:
                comando+=Integer.toString(1);
                break;
            case R.id.button2:
                comando+=Integer.toString(2);
                break;
            case R.id.button3:
                comando+=Integer.toString(3);
                break;
            case R.id.button4:
                comando+=Integer.toString(4);
                break;
        }

        Intent intent = new Intent(this,Ruta.class);
        intent.putExtra("comando",comando);
        startActivity(intent);
    }
}
