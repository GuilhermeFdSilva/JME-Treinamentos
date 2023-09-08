package com.guilherme.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.FragmentTransitionSupport;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.guilherme.fragments.R;
import com.guilherme.fragments.fragments.ContatosFragment;
import com.guilherme.fragments.fragments.ConversasFragment;

public class MainActivity extends AppCompatActivity {
    private Button buttonContatos, buttonConvarsas;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonContatos = findViewById(R.id.buttonContatos);
        buttonConvarsas = findViewById(R.id.buttonConversas);

        getSupportActionBar().setElevation(0);

        conversasFragment = new ConversasFragment();

        // Configurar o objeto para o fragmento
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.add(R.id.frameConteudo, conversasFragment);
        transition.commit();

        buttonContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatosFragment = new ContatosFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();
            }
        });

        buttonConvarsas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversasFragment = new ConversasFragment();
                FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.frameConteudo, conversasFragment);
                transition.commit();
            }
        });
    }
}