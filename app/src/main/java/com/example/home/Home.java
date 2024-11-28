package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton profileButton = findViewById(R.id.profileButton);
        ImageButton especiesButton = findViewById(R.id.fundoTop2);
        ImageButton plantasButton = findViewById(R.id.imagePlantas);
        ImageButton anfibiosButton = findViewById(R.id.imageAnfibios);
        ImageButton mamiferosButton = findViewById(R.id.imageMamiferos);
        ImageButton avesButton = findViewById(R.id.imageAves);
        ImageButton repteisButton = findViewById(R.id.imageRepteis);
        ImageButton peixesButton = findViewById(R.id.imagePeixes);
        ImageButton devButton = findViewById(R.id.fundoBottom2);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Login.class);
                startActivity(intent);
            }
        });
        especiesButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Infopage.class);
                startActivity(intent);
            }
        }));
        mamiferosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Mamiferos.class);
                startActivity(intent);
            }
        });
        devButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Desenvolvedores.class);
                startActivity(intent);
            }
        }));
    }
}