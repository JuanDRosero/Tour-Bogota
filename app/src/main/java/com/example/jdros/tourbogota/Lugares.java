package com.example.jdros.tourbogota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jdros.tourbogota.connection.FirebaseConnection;
import com.example.jdros.tourbogota.connection.InterfaceCallback;
import com.example.jdros.tourbogota.models.LugarModel;
import com.squareup.picasso.Picasso;

public class Lugares extends AppCompatActivity {
    private TextView tvNombre,tvDescripcion;
    private ImageView iv;
    private String comandoResult;
    private String id_ruta;
    FirebaseConnection firebase;
    //FirebaseDatabase database;
    //DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        getSupportActionBar().hide();

        tvNombre= (TextView) findViewById(R.id.textViewNombreL);
        tvDescripcion= (TextView) findViewById(R.id.textViewDesL);
        iv=(ImageView) findViewById(R.id.imageView);
        comandoResult=getIntent().getStringExtra("comando");
        id_ruta=getIntent().getStringExtra("ruta");
        tvNombre.setText(comandoResult);

       firebase= new FirebaseConnection();
       leerDatosLugar();
        // inicializarFirebase();
        //leerDatos();
    }



    private void leerDatosLugar() {
        firebase.leerLugar(comandoResult,id_ruta, new InterfaceCallback<LugarModel>() {
            @Override
            public void onCallback(LugarModel value) {
                tvNombre.setText(value.getNombre());
                tvDescripcion.setText(value.getDescripcion());
                Picasso.with(Lugares.this).load(value.getImg()).into(iv);
            }
        });

    }

    /* private void leerDatos() {
      comandoResult=getIntent().getStringExtra("comando");
      id_ruta=getIntent().getStringExtra("ruta");
      myRef.child("Rutas").child(id_ruta).child("Lugares").child(comandoResult).addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {


              LugarModel l = dataSnapshot.getValue(LugarModel.class);

              tvNombre.setText(l.getNombre());
              tvDescripcion.setText(l.getDescripcion());
              Picasso.with(Lugares.this).load(l.getImg()).into(iv);



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

    }*/
}
