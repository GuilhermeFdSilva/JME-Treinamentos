package com.guilherme.listadetarefas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guilherme.listadetarefas.R;
import com.guilherme.listadetarefas.model.Tarefa;

import java.util.List;

public class AdapterLista extends RecyclerView.Adapter<AdapterLista.MyViewHolder> {

    private List<Tarefa> listaTarefas;

    public AdapterLista (List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater
                                .from(parent.getContext())
                                .inflate(R.layout.lista_tarefa_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tarefa tarefa = listaTarefas.get(position);
        holder.viewTarefa.setText(tarefa.getNomeTarefa());
    }

    @Override
    public int getItemCount() {
        return listaTarefas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView viewTarefa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            viewTarefa = itemView.findViewById(R.id.textTarefa);
        }
    }
}
