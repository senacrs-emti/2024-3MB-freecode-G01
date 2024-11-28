package com.example.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private ImageButton imageProfile1, imageProfile2, imageProfile3;
    private CardView cardPerfil1, cardPerfil2, cardPerfil3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView voltarLogin = findViewById(R.id.setaAnimais);
        ImageButton devsLogin = findViewById(R.id.fundoBottom2);

        ImageButton imageProfile1 = findViewById(R.id.imageProfile1);
        ImageButton imageProfile2 = findViewById(R.id.imageProfile2);
        ImageButton imageProfile3 = findViewById(R.id.imageProfile3);

        CardView cardPerfil1 = findViewById(R.id.cardPerfil1);
        CardView cardPerfil2 = findViewById(R.id.cardPerfil2);
        CardView cardPerfil3 = findViewById(R.id.cardPerfil3);

        voltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
            }
        });
        devsLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Desenvolvedores.class);
                startActivity(intent);
            }
        });

        imageProfile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageSelected(cardPerfil1);
            }
        });
        imageProfile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageSelected(cardPerfil2);
            }
        });
        imageProfile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setImageSelected(cardPerfil3);
            }
        });
    }
    private void setImageSelected(CardView selectedCard) {
        // Remove o efeito de seleção dos outros cards
        cardPerfil1.setCardBackgroundColor(Color.TRANSPARENT);
        cardPerfil2.setCardBackgroundColor(Color.TRANSPARENT);
        cardPerfil3.setCardBackgroundColor(Color.TRANSPARENT);

        // Aplica a cor azul claro para o card selecionado
        selectedCard.setCardBackgroundColor(Color.parseColor("#ADD8E6")); // Azul claro
    }
}