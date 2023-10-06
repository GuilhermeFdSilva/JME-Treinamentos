package com.guilherme.listadetarefas.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.guilherme.listadetarefas.R;
import com.guilherme.listadetarefas.adapter.AdapterLista;
import com.guilherme.listadetarefas.databinding.ActivityMainBinding;
import com.guilherme.listadetarefas.helper.RecyclerItemClickListener;
import com.guilherme.listadetarefas.helper.TarefaDAO;
import com.guilherme.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private RecyclerView recyclerListaTarefas;
    private AdapterLista adapter;
    private TextView tarefasVazio;

    private List<Tarefa> listaTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });

        recyclerListaTarefas = findViewById(R.id.recyclerListaTarefas);
        recyclerListaTarefas.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerListaTarefas,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Tarefa tarefaSelecionada = listaTarefas.get(position);

                                Intent intent = new Intent(MainActivity.this, AdicionarTarefaActivity.class);
                                intent.putExtra("tarefaSelecionada", tarefaSelecionada);

                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Tarefa tarefaSelecionada = listaTarefas.get(position);

                                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                                dialog.setTitle("Confirmar exclusão");
                                dialog.setMessage(String.format("Deseja excluir a tarefa: %s ?", tarefaSelecionada.getNomeTarefa()));
                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        TarefaDAO dao = new TarefaDAO(getApplicationContext());
                                        if (dao.deletar(tarefaSelecionada)) {
                                            carregarListaTarefas();
                                            Toast.makeText(
                                                    getApplicationContext(),
                                                    "Tarefa excluida!",
                                                    Toast.LENGTH_LONG
                                            ).show();
                                        } else {
                                            Toast.makeText(
                                                    getApplicationContext(),
                                                    "Erro ao excluir tarefa",
                                                    Toast.LENGTH_LONG
                                            ).show();
                                        }
                                    }
                                });
                                dialog.setNegativeButton("Não", null);
                                dialog.create();
                                dialog.show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            }
                        }
                )
        );

        tarefasVazio = findViewById(R.id.textTarefasVazio);
    }

    @Override
    protected void onStart() {
        super.onStart();

        carregarListaTarefas();
    }

    public void carregarListaTarefas() {
        TarefaDAO dao = new TarefaDAO(getApplicationContext());
        listaTarefas = dao.listar();

        adapter = new AdapterLista(listaTarefas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerListaTarefas.setLayoutManager(layoutManager);
        recyclerListaTarefas.setHasFixedSize(true);
        recyclerListaTarefas.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerListaTarefas.setAdapter(adapter);

        if (listaTarefas.isEmpty()) {
            tarefasVazio.setVisibility(View.VISIBLE);
        } else {
            tarefasVazio.setVisibility(View.GONE);
        }
    }
}