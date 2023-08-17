package com.guilherme.listview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.guilherme.listview.R;
import com.guilherme.listview.activity.RecyclerItemClickListener;
import com.guilherme.listview.activity.adapter.Adapter;
import com.guilherme.listview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        this.criarFilmes();

        // Configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        // Evento de Clique
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item pressionado: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Click longo: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )
        );
    }

    public void criarFilmes() {

        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Captão América - Guerra Civíl", "Aventura/Focção", "2016");
        listaFilmes.add(filme);

        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Pica-Pau: O Filme", "Comédia/Animação", "2017");
        listaFilmes.add(filme);

        filme = new Filme("A Múmia", "Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Meu malvado favorito 3", "Comédia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Carros 3", "Comédia", "2017");
        listaFilmes.add(filme);

    }

}