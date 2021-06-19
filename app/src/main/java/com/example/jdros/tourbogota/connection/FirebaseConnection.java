package com.example.jdros.tourbogota.connection;

import com.example.jdros.tourbogota.models.LugarModel;
import com.example.jdros.tourbogota.models.RutaModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseConnection {

    FirebaseDatabase database;
    DatabaseReference myRef;
    LugarModel l;
    RutaModel r;
    public FirebaseConnection() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

    }


    public void leerLugar( String id_lugar, String id_ruta, final InterfaceCallback<LugarModel> callback) {

        myRef.child("Rutas").child(id_ruta).child("Lugares").child(id_lugar).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                l = dataSnapshot.getValue(LugarModel.class);
                callback.onCallback(l);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

    }
    public void leerRuta(String id_ruta, final InterfaceCallback<RutaModel> callback){
        myRef.child("Rutas").child(id_ruta).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                 r = dataSnapshot.getValue(RutaModel.class);
                callback.onCallback(r);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

    }

    public LugarModel getL() {
        return l;
    }
    public RutaModel getR(){
        return r;
    }
}
