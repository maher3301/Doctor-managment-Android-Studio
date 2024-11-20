package com.example.appmedecin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static final String Cn = "arij";
    private static final String Cp = "arij";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


            Button b5 = findViewById(R.id.b5);
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    EditText user = findViewById(R.id.editTextUsername);
                    String username = user.getText().toString();

                    EditText P = findViewById(R.id.editTextPassword);
                    String password = P.getText().toString();

                    TextView Message = findViewById(R.id.textViewMessage);

                    if (username.equals(Cn) && password.equals(Cp) ){

                        Message.setText("Connexion réussie !");
                        Toast.makeText(getApplicationContext(), " Bonjour " + username, Toast.LENGTH_LONG).show();
                        Intent i1= new Intent(getApplicationContext(),AjouterMed.class );
                        i1.putExtra("Name", username);
                        startActivity(i1);

                    } else {

                        Message.setText("Nom d'utilisateur ou mot de passe incorrect");

                    }
                }
            });
        }
    }
