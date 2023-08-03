package com.guilherme.projeto_fraseDoDia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fraseAleatoria (View view) {
        String[] frases = {
                "Você é capaz!",
                "Acredite em si mesmo.",
                "O fracasso é uma oportunidade para recomeçar com mais inteligência.",
                "Não desista, persista!",
                "Seja a mudança que você quer ver no mundo.",
                "Você tem o poder de fazer acontecer.",
                "Cada dia é uma nova chance de ser feliz.",
                "A jornada é tão importante quanto o destino.",
                "Aprenda com os erros e siga em frente.",
                "Pense positivo e atraia coisas boas.",
                "Acredite no seu potencial.",
                "O sucesso vem para aqueles que persistem.",
                "Nunca é tarde para recomeçar.",
                "Sua determinação é a chave do sucesso.",
                "O importante é nunca desistir.",
                "Encontre a felicidade nas coisas simples da vida.",
                "Você é mais forte do que imagina.",
                "A vida é cheia de possibilidades.",
                "Tudo é possível com dedicação e esforço.",
                "Acredite, você pode ir além!",
                "Nunca pare de aprender.",
                "Cada dia é uma nova chance de ser melhor.",
                "Acredite, você é único(a)!",
                "Nunca subestime seu próprio poder.",
                "Você é a luz no seu caminho.",
                "Faça o melhor que puder, com o que você tem, onde você está."
        };

        TextView texto = findViewById(R.id.frase);
        int indice = new Random().nextInt(frases.length);
        texto.setText(frases[indice]);
    }
}