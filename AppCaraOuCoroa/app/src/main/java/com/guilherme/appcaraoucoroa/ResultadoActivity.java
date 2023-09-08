package com.guilherme.appcaraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView imageResultado, voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        this.imageResultado = findViewById(R.id.imageResultado);
        this.voltar = findViewById(R.id.voltar);

        // "Settando" a imagem de acordo com os daos enviados
        ArrayList<Integer> moedas = new ArrayList<>(Arrays.asList(R.drawable.moeda_cara, R.drawable.moeda_coroa));
        Bundle dados = getIntent().getExtras();
        int resultado = dados.getInt("resultado");
        this.imageResultado.setImageResource(moedas.get(resultado));

        this.voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}