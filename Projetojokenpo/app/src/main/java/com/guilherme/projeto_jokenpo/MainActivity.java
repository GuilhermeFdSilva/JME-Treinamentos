package com.guilherme.projeto_jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        ImageView imgResultado = findViewById(R.id.imgResultado);
        TextView textoResultado = findViewById(R.id.textoInterativo);

        int numero = new Random().nextInt(3);
        String[] opcoes = { "pedra", "papel", "tesoura" };
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
        }

        if (
                opcaoApp == "pedra" && opcaoSelecionada == "tesoura"
                || opcaoApp == "papel" && opcaoSelecionada == "pedra"
                || opcaoApp == "tesoura" && opcaoSelecionada == "papel"
        ) {
            textoResultado.setText("Você perdeu! :(");
        } else if (
                opcaoSelecionada == "pedra" && opcaoApp == "tesoura"
                || opcaoSelecionada == "papel" && opcaoApp == "pedra"
                || opcaoSelecionada == "tesoura" && opcaoApp == "papel"
        ) {
            textoResultado.setText("Você ganhou!! :)");
        } else {
            textoResultado.setText("Empate");
        }
    }

    public void selecionadoPedra(View view) {
        opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        opcaoSelecionada("tesoura");
    }

}