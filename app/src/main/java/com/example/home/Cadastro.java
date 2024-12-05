package com.example.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastro extends AppCompatActivity {

    // Declaração das variáveis globais
    private ImageButton imageProfile1, imageProfile2, imageProfile3;
    private CardView cardPerfil1, cardPerfil2, cardPerfil3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Configuração para ajuste de barras do sistema (Edge-to-Edge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            // Para versões mais recentes do Android
            getWindow().setStatusBarColor(Color.parseColor("#8FBE9E")); // Definindo a barra de status como transparente
        } else {
            // Para versões anteriores do Android
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }


        // Inicializando os elementos do layout
        TextView voltarLogin = findViewById(R.id.setaAnimais);
        ImageButton devsLogin = findViewById(R.id.fundoBottom2);

        imageProfile1 = findViewById(R.id.imageProfile1);
        imageProfile2 = findViewById(R.id.imageProfile2);
        imageProfile3 = findViewById(R.id.imageProfile3);

        cardPerfil1 = findViewById(R.id.cardPerfil1);
        cardPerfil2 = findViewById(R.id.cardPerfil2);
        cardPerfil3 = findViewById(R.id.cardPerfil3);

        // Configurando os listeners para os botões de navegação
        voltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this, Home.class);
                startActivity(intent);
            }
        });
        devsLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this, Desenvolvedores.class);
                startActivity(intent);
            }
        });

        // Configurando os listeners para selecionar a imagem de perfil
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

    // Método para aplicar a cor e borda de seleção na imagem do card
    private void setImageSelected(CardView selectedCard) {
        // Remove o efeito de seleção dos outros cards (remover borda)
        cardPerfil1.setCardBackgroundColor(Color.TRANSPARENT);
        cardPerfil2.setCardBackgroundColor(Color.TRANSPARENT);
        cardPerfil3.setCardBackgroundColor(Color.TRANSPARENT);

        // Remove a borda dos outros cards (volta para o estado inicial)
        cardPerfil1.setBackgroundResource(0); // Remove o fundo do card
        cardPerfil2.setBackgroundResource(0); // Remove o fundo do card
        cardPerfil3.setBackgroundResource(0); // Remove o fundo do card

        // Aplica a borda azul clara no card selecionado
        selectedCard.setCardBackgroundColor(Color.parseColor("#ADD8E6")); // Cor de fundo azul claro
        selectedCard.setBackgroundResource(R.drawable.card_border); // Aplica a borda do drawable
    }
}
