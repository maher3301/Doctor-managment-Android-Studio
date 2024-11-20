package com.example.appmedecin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AjouterMed extends AppCompatActivity {
    String[] specialite = new String[] {"Medecin de famille" , "Pédiatre","Génycologue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_med);
        Bundle bdl = getIntent().getExtras();
        TextView tx = findViewById(R.id.tt1);
        String username = bdl.getString("Name");
        tx.setText("Bonjour " + username);





        FirebaseFirestore db= FirebaseFirestore.getInstance();
        EditText e1=findViewById(R.id.e1);
        EditText e2=findViewById(R.id.e2) ;
        EditText e3=findViewById(R.id.e3);
        EditText e4=findViewById(R.id.e4);
        Button ok=findViewById(R.id.ok);
        Button b2=findViewById(R.id.b2);
        Button b4=findViewById(R.id.b4);


        Spinner s=findViewById(R.id.s);
        ArrayAdapter<String> adp=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,specialite);
        s.setAdapter(adp);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
            }
        });

         b4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i=new Intent(getApplicationContext(), MainActivity.class);
                 startActivity(i);
             }
         });
        ok.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                Map<String, Object> doc = new HashMap<>();

                doc.put("Nom", e1.getText().toString());
                doc.put("Specialite", s.getSelectedItem().toString());
                doc.put("Telephone", e2.getText().toString());
                doc.put("Address", e3.getText().toString());
                doc.put("Email", e4.getText().toString());



                db.collection("Medecin").add(doc).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(getApplicationContext(), "Votre enregistrement est faite avce succee ", Toast.LENGTH_LONG).show();
                                Intent i= new Intent(getApplicationContext(),Annuaire.class);
                                startActivity(i);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "echec d'enregistrement ", Toast.LENGTH_LONG).show();

                            }
                        });

            }
        });
    } }