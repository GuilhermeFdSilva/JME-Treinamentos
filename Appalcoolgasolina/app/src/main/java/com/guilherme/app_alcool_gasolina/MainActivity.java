package com.guilherme.app_alcool_gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcool, editGasolina;
    private TextView textRetorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool = findViewById(R.id.editAlcool);
        editGasolina = findViewById(R.id.editGasolina);

        textRetorno = findViewById(R.id.txtRetorno);
    }

    public void calcularPreco(View view) {
        String precoAlcool = editAlcool.getText().toString();
        String precoGasolina = editGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if (camposValidados) {
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            if (valorAlcool / valorGasolina >= 0.7) {
                textRetorno.setText("Melhor utilizar Gasolina");
            } else {
                textRetorno.setText("Melhor utilizar Álcool");
            }
        } else {
            textRetorno.setText("Preencha os preços primeiro!");
        }
    }

    public Boolean validarCampos (String pAlcool, String pGasolina) {
        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }
}