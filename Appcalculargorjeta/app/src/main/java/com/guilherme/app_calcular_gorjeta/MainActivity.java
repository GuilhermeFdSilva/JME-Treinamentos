package com.guilherme.app_calcular_gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputValor;
    private SeekBar seekBar;
    private TextView porcentagem, respostaGorjeta, respostaTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValor = findViewById(R.id.inputValor);
        seekBar = findViewById(R.id.seekBar);
        porcentagem = findViewById(R.id.porcentagem);
        respostaGorjeta = findViewById(R.id.respostaGorjeta);
        respostaTotal = findViewById(R.id.respostaTotal);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem.setText(i + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular() {
        String valor = inputValor.getText().toString();
        if (valor.equals("") || valor == null) {
            Toast.makeText(getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_SHORT).show();
        } else {
            double valorDouble = Double.parseDouble(valor);
            double gorjeta = valorDouble * (seekBar.getProgress() / 100.0);
            double total = valorDouble + gorjeta;
            respostaGorjeta.setText(String.format("R$ %.2f", gorjeta));
            respostaTotal.setText(String.format("R$ %.2f", total));
        }
    }
}