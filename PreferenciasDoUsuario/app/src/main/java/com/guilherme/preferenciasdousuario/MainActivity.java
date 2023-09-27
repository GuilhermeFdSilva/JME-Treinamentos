package com.guilherme.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private TextInputEditText editNome;
    private TextView textResposta;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        editNome = findViewById(R.id.editNome);
        textResposta = findViewById(R.id.textResposta);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                if (editNome.getText().toString().equals("") ) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Preencha o nome",
                            Toast.LENGTH_LONG).show();
                } else {
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();

                    textResposta.setText("Olá " + nome);
                }
            }
        });

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (preferences.contains("nome")) {
            String nome = preferences.getString("nome", "usuário não definido");
            textResposta.setText("Olá " + nome);
        } else {
            textResposta.setText("Olá, usuário não definido");
        }
    }
}