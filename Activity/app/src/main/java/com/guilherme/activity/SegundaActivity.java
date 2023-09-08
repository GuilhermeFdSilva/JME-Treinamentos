package com.guilherme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        this.textNome = findViewById(R.id.textNome);
        this.textIdade = findViewById(R.id.textIdade);

        Bundle dados = getIntent().getExtras();

        String nome = dados.getString("nome");
        String idade = dados.getString("idade");

        this.textNome.setText(nome);
        this.textIdade.setText(idade);
    }
}