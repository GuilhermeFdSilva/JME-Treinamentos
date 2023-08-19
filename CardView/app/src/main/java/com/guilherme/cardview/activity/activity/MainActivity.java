package com.guilherme.cardview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.guilherme.cardview.R;
import com.guilherme.cardview.activity.adapter.Adapter;
import com.guilherme.cardview.activity.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        prepararPostagens();

        // Definir Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Definir adapter
        Adapter adapter = new Adapter(postagens);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void prepararPostagens() {
        Postagem p = new Postagem("Guilherme França", "#tbt Viagem maneira", R.drawable.imagem1);
        postagens.add(p);

        p = new Postagem("Evelin Mejia", "Saudades dessa vista", R.drawable.imagem2);
        postagens.add(p);

        p = new Postagem("Evelin Mejia", "#tbt #Paris", R.drawable.imagem3);
        postagens.add(p);

        p = new Postagem("André Henrrique", "#Paz #Amor", R.drawable.imagem4);
        postagens.add(p);
    }
}