package com.guilherme.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonAbrir, buttonFechar;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonAbrir = findViewById(R.id.buttonAbrir);
        this.buttonFechar = findViewById(R.id.buttonFechar);

        buttonAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar = Snackbar.make(view, "Botão pressionado", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Confirmar", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // buttonAbrir.setText("Botão alterado");
                            }
                        }).setActionTextColor(getColor(R.color.redAccent));
                snackbar.show();
            }
        });

        this.buttonFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
    }
}