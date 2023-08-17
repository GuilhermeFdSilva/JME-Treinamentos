package com.guilherme.componentes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView resultado, resultadoSexo, resultadoSwitch, resultadoToggle, resultadoSeekbar ;

    // CheckBox
    private CheckBox checkVermelho, checkAmarelo, checkAzul;

    // RadioButton
    private RadioButton radioMasculino, radioFeminino;
    private RadioGroup opcaoSexo;

    // Toggle
    private Switch switchSenha;
    private ToggleButton toggleButton;

    // ProgressBar
    private ProgressBar progressBarHorizont, progressBarCirc;
    private int progresso = 0;

    //Seekbar
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        resultadoSexo = findViewById(R.id.resultadoSexo);
        resultadoSwitch = findViewById(R.id.resultadoSwitch);
        resultadoToggle = findViewById(R.id.resultadoToggle);
        resultadoSeekbar = findViewById(R.id.resultadoSeekbar);

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

        // Toggles
        switchSenha = findViewById(R.id.switchSenha);
        toggleButton = findViewById(R.id.toggleButton);

        // ProgressBar
        progressBarHorizont = findViewById(R.id.progressBarHorizont);
        progressBarCirc = findViewById(R.id.progressBarCirc);
        progressBarCirc.setVisibility(View.GONE);

        //Seekbar
        seekBar = findViewById(R.id.seekBar);

        radioButtonListener();
        switchListener();
        toggleListener();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                resultadoSeekbar.setText(i + " / " + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    public void switchListener() {
        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    resultadoSwitch.setText("Lembrar senha? Sim");
                } else {
                    resultadoSwitch.setText("Lembrar senha? Não");
                }
            }
        });
    }

    public void toggleListener() {
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    resultadoToggle.setText("Toggle Buton: Ligado");
                } else {
                    resultadoToggle.setText("Toggle Buton: Desligado");
                }
            }
        });
    }

    public void enviar(View view) {
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        String retorno = String.format("Nome: %s\nEmail: %s\n%s", nome, email, checkBox());

        resultado.setText(retorno);
        radioButton();
    }

    public void limpar(View view) {
        campoNome.setText("");
        campoEmail.setText("");
        resultado.setText("Resultado");
        resultadoSexo.setText("Resultado Sexo");
    }

    public void abrirToast(View view) {
        ImageView image = new ImageView(getApplicationContext());
        image.setImageResource(android.R.drawable.star_big_off);

        Toast toast = new Toast(getApplicationContext());

        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(image);
        toast.show();

//        Toast.makeText(getApplicationContext(),
//                "Ação realizada com sucesso",
//                Toast.LENGTH_SHORT).show();
    }

    public void abrirDialog(View view) {
        // Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        // Configurar titulo e mensagem
        dialog.setTitle("Título da dialog");
        dialog.setMessage("Mensagem da dialog");

        // Configurar cancelamento
        dialog.setCancelable(false);

        // Configurar Icone
        dialog.setIcon(android.R.drawable.btn_star_big_off);

        // Configurar as ações para sim e não
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                        "Executar a ação ao clicar no botão Sim",
                        Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                        "Executar a ação ao clicar no botão Não",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Criar e exibir a Dialog
        dialog.create().show();
    }

    public void carregarProgressBar(View view) {
        // ProgressBar horizontal
        this.progresso++;
        progressBarHorizont.setProgress(progresso);
        progressBarCirc.setVisibility(View.VISIBLE);

        if (progresso >= 10) {
            progressBarCirc.setVisibility(View.GONE);
        }
    }

    public void recuperarProgrsso(View view) {
        resultadoSeekbar.setText("Escolhido: " + seekBar.getProgress());
    }
}