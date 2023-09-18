package com.guilherme.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.guilherme.atmconsultoria.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes, R.id.nav_contato, R.id.nav_sobre)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        FloatingActionButton fab = binding.appBarMain.fab;
        fab.setOnClickListener((view) -> {
            enviarEmail();
        });
    }

    public void enviarEmail() {
        String celular = "tel:11979741043";
        String imagem = "https://www.pinclipart.com/picdir/big/339-3397473_positive-png-clipart.png";
        String endereco = "https://www.google.com.br/maps/place/Museu+de+Zoologia+da+Universidade+de+S%C3%A3o+Paulo/@-23.5447894,-46.7675512,13z/data=!4m10!1m2!2m1!1sMuseus!3m6!1s0x94ce5be87b8b646b:0x2011c5e69df48003!8m2!3d-23.5881661!4d-46.610124!15sCgZNdXNldXOSARFtdXNldW1fb2Zfem9vbG9neeABAA!16s%2Fm%2F0k3ln5f?entry=ttu";

        // CALL precisa de permição do app
        // Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(celular));
        // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));

        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        intent.setType("message/rfc822");
        // intent.setType("image/*");
        // intent.setType("text/plain");

        startActivity(Intent.createChooser(intent, "Escolha um App de e-mail"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}