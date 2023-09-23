package com.guilherme.abas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.guilherme.abas.fragments.EmAltaFragment;
import com.guilherme.abas.fragments.HomeFragment;
import com.guilherme.abas.fragments.InscricoesFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout abas;
    private ViewPager conteudoAba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abas = findViewById(R.id.abas);
        conteudoAba = findViewById(R.id.conteudoAba);

        getSupportActionBar().setElevation(0);

        // Configurar adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment.class)
                        .add("Inscrições", InscricoesFragment.class)
                        .add("Em alta", EmAltaFragment.class)
                        .create()
        );

        conteudoAba.setAdapter(adapter);
        abas.setViewPager(conteudoAba);
    }
}