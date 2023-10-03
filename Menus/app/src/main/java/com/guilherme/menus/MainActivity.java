package com.guilherme.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idItem = item.getItemId();

        if (idItem == R.id.itemSalvar) {
            Toast.makeText(MainActivity.this, "Item Salvar", Toast.LENGTH_SHORT).show();
        } else if (idItem == R.id.itemEditar) {
            Toast.makeText(MainActivity.this, "Item Editar", Toast.LENGTH_SHORT).show();
        } else if (idItem == R.id.itemConfiguracao) {
            Toast.makeText(MainActivity.this, "Item Configurações", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}