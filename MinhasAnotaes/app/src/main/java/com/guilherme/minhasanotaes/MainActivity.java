package com.guilherme.minhasanotaes;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.guilherme.minhasanotaes.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AnotacaoPreferencias anotacaoPreferencias;

    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        anotacaoPreferencias = new AnotacaoPreferencias(getApplicationContext());

        editAnotacao = findViewById(R.id.editAnotacao);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anotacaoPreferencias.salvarAnotacao(editAnotacao.getText().toString());
                Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
            }
        });

        editAnotacao.setText(anotacaoPreferencias.recuperarAnotacao());
    }
}