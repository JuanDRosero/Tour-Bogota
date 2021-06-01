package com.example.jdros.tourbogota;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jdros.tourbogota.models.RutaModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Ruta extends AppCompatActivity {





    FirebaseDatabase database;
    DatabaseReference myRef;

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
        /*cm=getIntent().getStringExtra("comando");
        tvNombre.setText(cm);*/

        inicializarFirebase();
        leerDatos();
    }
    private void leerDatos() {
        cm=getIntent().getStringExtra("comando");
        myRef.child("Rutas").child(cm).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                    RutaModel r = dataSnapshot.getValue(RutaModel.class);

                    tvNombre.setText(r.getNombre());
                    tvDescription.setText(r.getDescripcion());
                    Picasso.with(Ruta.this).load(r.getImgmapa()).into(ivMapa);
                    /*list_view_rutas_adapter = new List_View_Rutas_Adapter(Ruta.this,l);
                    List_lugares.setAdapter(list_view_lugares_adapter);*/


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }

    private void inicializarFirebase(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

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
        intent.putExtra("ruta",cm);
        startActivity(intent);
    }
}
