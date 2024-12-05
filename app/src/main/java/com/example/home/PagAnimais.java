package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PagAnimais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pag_animais);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Recebe os dados passados pela Intent
        String nomeAnimal = getIntent().getStringExtra("NOME_ANIMAL");
        String descricaoAnimal = getIntent().getStringExtra("DESCRICAO_ANIMAL");
        String estadoAnimal = getIntent().getStringExtra("ESTADO_ANIMAL");
        String existentesAnimal = String.valueOf(getIntent().getIntExtra("EXISTENTES_ANIMAL", 0));  // Converte o inteiro para string



        // Exibe os dados na interface
        TextView animalNome = findViewById(R.id.animalName);
        TextView animalDescricao = findViewById(R.id.animalDescricao);
        TextView animalEstado = findViewById(R.id.animalEstado);
        TextView animalExistentes = findViewById(R.id.animalExistentes);

        animalNome.setText(nomeAnimal);
        animalDescricao.setText(descricaoAnimal);
        animalEstado.setText(estadoAnimal);
        animalExistentes.setText(existentesAnimal);

        // Configura os botões de navegação
        ImageButton profileAnimal = findViewById(R.id.profileButtonAnimais);
        TextView animaisVoltar = findViewById(R.id.setaAnimais);

        profileAnimal.setOnClickListener(v -> {
            Intent intent = new Intent(PagAnimais.this, Cadastro.class);
            startActivity(intent);
        });

        animaisVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(PagAnimais.this, Mamiferos.class);
            startActivity(intent);
        });
    }
}
