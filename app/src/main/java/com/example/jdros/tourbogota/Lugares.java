package com.example.jdros.tourbogota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jdros.tourbogota.models.LugarModel;
import com.example.jdros.tourbogota.models.RutaModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

public class Lugares extends AppCompatActivity {
    private TextView tvNombre,tvDescripcion;
    private ImageView iv;
    private String comandoResult;
    private String id_ruta;
    FirebaseDatabase database;
    DatabaseReference myRef;

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

        inicializarFirebase();
        leerDatos();
    }

    private void leerDatos() {
        comandoResult=getIntent().getStringExtra("comando");
        id_ruta=getIntent().getStringExtra("ruta");
        myRef.child("Rutas").child(id_ruta).child("Lugares").child(comandoResult).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                LugarModel l = dataSnapshot.getValue(LugarModel.class);

                tvNombre.setText(l.getNombre());
                tvDescripcion.setText(l.getDescripcion());
                Picasso.with(Lugares.this).load(l.getImg()).into(iv);
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
}
