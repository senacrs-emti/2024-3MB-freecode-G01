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
        int imagemAnimal = getIntent().getIntExtra("IMAGEM_ANIMAL", R.drawable.ic_launcher_background); // Use um drawable default se não for fornecido

        // Exibe os dados na interface
        TextView animalNome = findViewById(R.id.animalName);
        TextView animalDescricao = findViewById(R.id.animalDescricao);

        animalNome.setText(nomeAnimal);
        animalDescricao.setText(descricaoAnimal);

        // Configura os botões de navegação
        ImageButton profileAnimal = findViewById(R.id.profileButtonAnimais);
        TextView animaisVoltar = findViewById(R.id.setaAnimais);

        profileAnimal.setOnClickListener(v -> {
            Intent intent = new Intent(PagAnimais.this, Login.class);
            startActivity(intent);
        });

        animaisVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(PagAnimais.this, Mamiferos.class);
            startActivity(intent);
        });
    }
}
