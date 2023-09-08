package com.guilherme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextInputEditText nome, email, idade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = findViewById(R.id.buttonEnviar);
        this.nome = findViewById(R.id.inputNome);
        this.email = findViewById(R.id.inputEmail);
        this.idade = findViewById(R.id.inputIdade);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                Usuario usuario = new Usuario(nome.getText().toString(),
                        email.getText().toString(),
                        Integer.parseInt(idade.getText().toString()));

                intent.putExtra("objeto", usuario);

                startActivity(intent);
            }
        });
    }
}