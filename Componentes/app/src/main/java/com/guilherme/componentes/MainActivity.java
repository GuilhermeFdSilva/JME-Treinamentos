package com.guilherme.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView resultado, resultadoSexo;

    // CheckBox
    private CheckBox checkVermelho, checkAmarelo, checkAzul;

    // RadioButton
    private RadioButton radioMasculino, radioFeminino;
    private RadioGroup opcaoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        resultadoSexo = findViewById(R.id.resultadoSexo);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);

        // CheckBox
        checkVermelho = findViewById(R.id.checkVermelho);
        checkAmarelo = findViewById(R.id.checkAmarelo);
        checkAzul = findViewById(R.id.checkAzul);

        // RadioButton
        radioMasculino = findViewById(R.id.radioMasculino);
        radioFeminino = findViewById(R.id.radioFeminino);

        // RadioGroup
        opcaoSexo = findViewById(R.id.opcaoSexo);

        radioButtonListener();
    }

    public String checkBox() {
        String suasCores = "";
        String vermelho = checkVermelho.isChecked() ? checkVermelho.getText().toString() : "";
        String amarelo = checkAmarelo.isChecked() ? checkAmarelo.getText().toString() : "";
        String azul = checkAzul.isChecked() ? checkAzul.getText().toString() : "";
        if ((suasCores + vermelho + amarelo + azul).length() == 0) {
            return suasCores;
        } else {
            suasCores = String.format("Suas cores são: %s, %s, %s", vermelho, amarelo, azul);
            return suasCores;
        }
    }

    public void radioButton() {
        if (radioMasculino.isChecked()) {
            resultadoSexo.setText("Sexo: Masculino");
        }
        if (radioFeminino.isChecked()) {
            resultadoSexo.setText("Sexo: Feminino");
        }
        resultadoSexo.setText("Resultado Sexo");
    }

    public void radioButtonListener() {
        opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == radioMasculino.getId()) {
                    resultadoSexo.setText("Sexo: Masculino");
                }
                if (id == radioFeminino.getId()) {
                    resultadoSexo.setText("Sexo: Feminino");
                }
            }
        });
    }

    public void enviar(View view) {
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        String retorno = String.format("Nome: %s\nEmail: %s\n%s", nome, email, checkBox());

        resultado.setText(retorno);
    }

    public void limpar(View view) {
        campoNome.setText("");
        campoEmail.setText("");
        resultado.setText("Resultado");
        resultadoSexo.setText("Resultado Sexo");
    }

}