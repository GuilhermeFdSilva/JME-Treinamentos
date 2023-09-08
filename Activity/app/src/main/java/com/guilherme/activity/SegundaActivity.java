package com.guilherme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textEmail, textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        this.textNome = findViewById(R.id.textNome);
        this.textEmail = findViewById(R.id.textEmail);
        this.textIdade = findViewById(R.id.textIdade);

        Bundle dados = getIntent().getExtras();

        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        this.textNome.setText(usuario.getNome());
        this.textEmail.setText(usuario.getEmail());
        this.textIdade.setText(String.valueOf(usuario.getIdade()) + " anos");
    }
}