package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.home.controller.NetworkUtilAnimaisExtintos;
import com.example.home.model.AnimaisExtintosModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<AnimaisExtintosModel> animaisList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configuração das barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Botão de navegação
        Button button = findViewById(R.id.iniciar);

        // Iniciar a requisição de dados da API
        NetworkUtilAnimaisExtintos networkUtilAnimaisExtintos = new NetworkUtilAnimaisExtintos();
        networkUtilAnimaisExtintos.getRequestWithOkHttp();

        // Atraso para esperar a requisição da API
        new android.os.Handler().postDelayed(() -> {
            // Obter a lista de animais após a requisição
            animaisList = networkUtilAnimaisExtintos.getAnimaisList();
            if (animaisList != null && !animaisList.isEmpty()) {
                // Exibir um Toast quando a lista for carregada com sucesso
                Toast.makeText(MainActivity.this, "Pronto para iniciar ", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", "Número de animais carregados: " + animaisList.size());
            } else {
                // Exibir um Toast em caso de erro ou lista vazia
                Toast.makeText(MainActivity.this, "Falha ao carregar a lista de animais.", Toast.LENGTH_SHORT).show();
                Log.e("MainActivity", "A lista de animais está vazia ou a requisição falhou.");
            }

            // Configurar o listener para o botão
            button.setOnClickListener(v -> {
                // Passar a lista de animais para a HomeActivity
                Intent intent = new Intent(MainActivity.this, Home.class);
                intent.putParcelableArrayListExtra("ANIMAIS_LIST", new java.util.ArrayList<>(animaisList));
                startActivity(intent);
            });

        }, 2000); // Tempo de atraso para simular o tempo da requisição
    }
}
