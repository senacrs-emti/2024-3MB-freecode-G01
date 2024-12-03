package com.example.home;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Infopage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_infopage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView voltarInfo = findViewById(R.id.setaInfopage);
        ImageButton perfilInfo = findViewById(R.id.imgPerfilInfo);
        ImageView fundo2 = findViewById(R.id.fundoCausas);
        ImageView fundo3 = findViewById(R.id.fundoAmbiente);
        ImageView fundo4 = findViewById(R.id.fundoConserv);

        voltarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Infopage.this, Home.class);
                startActivity(intent);
            }
        });
        perfilInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Infopage.this, Cadastro.class);
                startActivity(intent);
            }
        });
        ColorFilter colorFilter = new PorterDuffColorFilter(Color.parseColor("#9CA548"), PorterDuff.Mode.SRC_ATOP);
        fundo2.setColorFilter(colorFilter);
        ColorFilter colorFilter2 = new PorterDuffColorFilter(Color.parseColor("#B56D15"), PorterDuff.Mode.SRC_ATOP);
        fundo3.setColorFilter(colorFilter2);
        ColorFilter colorFilter3 = new PorterDuffColorFilter(Color.parseColor("#BA901D"), PorterDuff.Mode.SRC_ATOP);
        fundo4.setColorFilter(colorFilter3);

    }
}