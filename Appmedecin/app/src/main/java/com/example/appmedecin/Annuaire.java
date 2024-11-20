package com.example.appmedecin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Annuaire extends AppCompatActivity {
    ArrayList<String> noms=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annuaire);
        ListView l1=findViewById(R.id.l1);
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("Medecin").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot doc:task.getResult()){
                        String n=doc.get("Nom").toString();
                        noms.add(n);
                        ArrayAdapter<String> adp=new ArrayAdapter<>(Annuaire.this,android.R.layout.simple_list_item_1,noms);
                        l1.setAdapter(adp);
                    }

                }

            }
        });


    }
}