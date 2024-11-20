package com.example.appmedecin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.b1);
        Button AU = findViewById(R.id.AU);
        Button CU = findViewById(R.id.CU);
        Button b44 = findViewById(R.id.b44);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
        b44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });

        AU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });

        CU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
            }
        });
    }

    public void onButtonClick(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_animation);
        view.startAnimation(animation);

        // Ajoutez ici le code supplémentaire à exécuter lorsque le bouton est cliqué
        if (view.getId() == R.id.b1) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        } else if (view.getId() == R.id.AU) {
            Intent i = new Intent(MainActivity.this, aboutus.class);
            startActivity(i);
        } else if (view.getId() == R.id.CU) {
            Intent i = new Intent(MainActivity.this, contactus.class);
            startActivity(i);
        }else if (view.getId() == R.id.b44) {
            Intent i = new Intent(MainActivity.this, ConfActivity.class);
            startActivity(i);}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.acc) {
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.nou) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.ann) {
            Intent ii = new Intent(MainActivity.this, Annuaire.class);
            startActivity(ii);
        }else if (item.getItemId() == R.id.ap) {
            Intent ii = new Intent(MainActivity.this, aboutus.class);
            startActivity(ii);
        }else if (item.getItemId() == R.id.cu) {
            Intent ii = new Intent(MainActivity.this, contactus.class);
            startActivity(ii);
        }else if (item.getItemId() == R.id.rg) {
            Intent ii = new Intent(MainActivity.this, ConfActivity.class);
            startActivity(ii);}
        return true;
    }
}
