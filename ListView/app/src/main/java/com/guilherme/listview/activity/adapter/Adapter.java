package com.guilherme.listview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guilherme.listview.R;
import com.guilherme.listview.activity.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyVielHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyVielHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);
        return new MyVielHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVielHolder holder, int position) {
        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    class MyVielHolder extends RecyclerView.ViewHolder {

        TextView titulo, ano, genero;

        public MyVielHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }

}
