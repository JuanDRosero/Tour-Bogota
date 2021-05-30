package com.example.jdros.tourbogota;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Ruta extends AppCompatActivity {

    private TextView tvNombre,tvDescription;
    private ImageView ivMapa;
    private String cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);

        getSupportActionBar().hide();
        tvNombre= (TextView) findViewById(R.id.textViewRuta);
        tvDescription=(TextView) findViewById(R.id.textViewDescripcion);
        ivMapa = (ImageView) findViewById(R.id.imageViewMapa);
        //El comando que recibe es "select * from Rutas wherePK_Ruta=#rura"
        cm=getIntent().getStringExtra("comando");
        tvNombre.setText(cm);
    }

    public void iniciarLector(View view){
        //En este metodo se debe iniciar el lector de codigos QR
        new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String comandoResultado;
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        comandoResultado=result.getContents();

        Intent intent = new Intent(this,Lugares.class);
        intent.putExtra("comando",comandoResultado);
        startActivity(intent);
    }
}
