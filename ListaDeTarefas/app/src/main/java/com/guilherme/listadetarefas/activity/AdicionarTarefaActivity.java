package com.guilherme.listadetarefas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.guilherme.listadetarefas.R;
import com.guilherme.listadetarefas.databinding.ActivityAdicionarTarefaBinding;
import com.guilherme.listadetarefas.helper.TarefaDAO;
import com.guilherme.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private ActivityAdicionarTarefaBinding binding;

    private TextInputEditText inputTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdicionarTarefaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        inputTarefa = findViewById(R.id.inputTarefa);

        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        if (tarefaAtual != null) {
            inputTarefa.setText(tarefaAtual.getNomeTarefa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.itemSalvar) {
            TarefaDAO dao = new TarefaDAO(getApplicationContext());

            String nomeTarefa = inputTarefa.getText().toString();
            if (!nomeTarefa.isEmpty()) {
                if (tarefaAtual != null) {
                    tarefaAtual.setNomeTarefa(nomeTarefa);

                    if (dao.atualizar(tarefaAtual)) {
                        Toast.makeText(
                                getApplicationContext(),
                                "Tarefa atualizada!",
                                Toast.LENGTH_LONG
                        ).show();
                        finish();
                    }
                } else {
                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomeTarefa);

                    if (dao.salvar(tarefa)) {
                        finish();
                        Toast.makeText(
                                getApplicationContext(),
                                "Tarefa salva!",
                                Toast.LENGTH_LONG).show();
                    }
                }
            } else {
                Snackbar.make(inputTarefa, "Preencha os campos", Snackbar.LENGTH_LONG).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}