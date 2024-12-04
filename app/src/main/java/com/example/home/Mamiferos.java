package com.example.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.home.controller.NetworkUtilAnimaisExtintos;
import com.example.home.model.AnimaisExtintosModel;

import java.util.List;

public class Mamiferos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mamiferos);

        // Configuração das barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Encontrando elementos do layout
        TextView voltar = findViewById(R.id.setaAnimais);
        ImageButton perfilAnimais = findViewById(R.id.profileButtonMamiferos);
        ConstraintLayout constraintLayout1 = findViewById(R.id.constraintLayout1); // ConstraintLayout onde os botões serão adicionados
        ConstraintLayout constraintLayout2 = findViewById(R.id.constraintLayout2); // ConstraintLayout onde os botões serão adicionados

        voltar.setOnClickListener(v -> {
            Intent intent = new Intent(Mamiferos.this, Home.class);
            startActivity(intent);
        });

        perfilAnimais.setOnClickListener(v -> {
            Intent intent = new Intent(Mamiferos.this, Login.class);
            startActivity(intent);
        });

        // Chama a API
        NetworkUtilAnimaisExtintos networkUtilAnimaisExtintos = new NetworkUtilAnimaisExtintos();
        networkUtilAnimaisExtintos.getRequestWithOkHttp();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // Obtém a lista de animais após a requisição
            List<AnimaisExtintosModel> animaisList = networkUtilAnimaisExtintos.getAnimaisList();
            if (animaisList != null) {
                Log.d("Mamiferos", "Número de animais recebidos: " + animaisList.size());
                int topMargin = 20; // Inicializa a margem superior para o primeiro botão

                // Cria um botão para cada animal
                for (int i = 0; i < animaisList.size(); i++) {
                    AnimaisExtintosModel animal = animaisList.get(i);
                    Log.d("Mamiferos", "Verificando animal: " + animal.getNome() + " com classe: " + animal.getClasse());

                    // Filtra os animais pela classe
                    if (animal.getClasse() == 1) {
                        Log.d("Mamiferos", "Adicionando animal: " + animal.getNome() + " com classe: " + animal.getClasse());
                        Button button = new Button(Mamiferos.this);

                        // Cria um novo botão programaticamente
                        button.setId(View.generateViewId());
                        button.setText(animal.getNome());
                        button.setBackgroundColor(getResources().getColor(android.R.color.white));
                        button.setTextColor(getResources().getColor(android.R.color.black));

                        // Cria e configura as constraints do botão
                        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                                ConstraintLayout.LayoutParams.MATCH_PARENT,
                                ConstraintLayout.LayoutParams.WRAP_CONTENT
                        );
                        layoutParams.setMargins(20, 20, 20, 20);
                        button.setLayoutParams(layoutParams);

                        // Adiciona o botão ao ConstraintLayout apropriado
                        ConstraintLayout targetLayout = (i % 2 == 0) ? constraintLayout1 : constraintLayout2;
                        targetLayout.addView(button);

                        // Cria uma nova ConstraintSet para configurar as constraints de cada botão
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.clone(targetLayout);

                        if (i % 2 == 0) {
                            // Para o primeiro botão de cada coluna, fixamos no topo do layout
                            if (targetLayout.getChildCount() == 1) {
                                constraintSet.connect(button.getId(), ConstraintSet.TOP, targetLayout.getId(), ConstraintSet.TOP, 100);
                            } else {
                                // Para os botões seguintes na coluna, posiciona abaixo do botão anterior
                                Button previousButton = (Button) targetLayout.getChildAt(targetLayout.getChildCount() - 2);
                                constraintSet.connect(button.getId(), ConstraintSet.TOP, previousButton.getId(), ConstraintSet.BOTTOM, 20);
                            }
                        } else {
                            // Para o primeiro botão de cada coluna, fixamos no topo do layout
                            if (targetLayout.getChildCount() == 1) {
                                constraintSet.connect(button.getId(), ConstraintSet.TOP, targetLayout.getId(), ConstraintSet.TOP, 100);
                            } else {
                                // Para os botões seguintes na coluna, posiciona abaixo do botão anterior
                                Button previousButton = (Button) targetLayout.getChildAt(targetLayout.getChildCount() - 2);
                                constraintSet.connect(button.getId(), ConstraintSet.TOP, previousButton.getId(), ConstraintSet.BOTTOM, 20);
                            }
                        }

                        // Alinha os botões ao centro (horizontalmente)
                        constraintSet.connect(button.getId(), ConstraintSet.START, targetLayout.getId(), ConstraintSet.START, 20);
                        constraintSet.connect(button.getId(), ConstraintSet.END, targetLayout.getId(), ConstraintSet.END, 20);

                        // Aplica as novas constraints ao layout
                        constraintSet.applyTo(targetLayout);

                        // Configura um OnClickListener para o botão
                        button.setOnClickListener(v -> {
                            Log.d("Button Clicked", "Animal: " + animal.getNome());

                            // Passa os dados para a PagAnimaisActivity
                            Intent intent = new Intent(Mamiferos.this, PagAnimais.class);
                            intent.putExtra("NOME_ANIMAL", animal.getNome());
                            intent.putExtra("DESCRICAO_ANIMAL", animal.getSobre()); // Supondo que você tenha o método getDescricao()
                            // Inicia a Activity de detalhes do animal
                            startActivity(intent);
                        });
                    }
                }
            } else {
                Log.e("Mamiferos", "A lista de animais está vazia ou a requisição falhou.");
            }
        }, 2000);  // Atraso para esperar a resposta da API
    }
}
