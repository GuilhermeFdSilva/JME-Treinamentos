package com.guilherme.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    private TextView textTempo;
    private SeekBar seekBarTempo, seekBarVolume;

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarTempo = findViewById(R.id.seekBarTempo);
        seekBarVolume = findViewById(R.id.seekBarVolume);
        textTempo = findViewById(R.id.textTempo);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.children_of_the_sky);
        prepararSeekBarTempo();
        prepararSeekBarVolume();
    }

    public void executarSom(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            atualizarViewsTempo();
        }
    }

    public void pausarSom(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void pararSom(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.children_of_the_sky);
            prepararSeekBarTempo();
        }
    }

    private void atualizarViewTempo() {
        int tempoSegundos = seekBarTempo.getProgress() / 1000;
        int minutos = tempoSegundos / 60;
        int segundos = tempoSegundos % 60;

        String stringFinal = String.format("%d:%02d", minutos, segundos);

        this.textTempo.setText(stringFinal);
    }

    private void atualizarSeekBarTempoEViewTempo() {
        seekBarTempo.setProgress(mediaPlayer.getCurrentPosition());
        atualizarViewTempo();
    }

    private void atualizarViewsTempo() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                atualizarSeekBarTempoEViewTempo();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        atualizarViewsTempo();
                    }
                }, 1000);
            }
        }
    }

    private void prepararSeekBarTempo() {
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    seekBarTempo.setMax(mediaPlayer.getDuration());
                    atualizarSeekBarTempoEViewTempo();
                    seekBarTempo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                            if (b) {
                                mediaPlayer.seekTo(i);
                                atualizarSeekBarTempoEViewTempo();
                            }
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                            pausarSom(getCurrentFocus());
                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                            executarSom(getCurrentFocus());
                        }
                    });
                }
            });
        }
    }

    private void prepararSeekBarVolume() {
        // Configurar audio mananger
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Recuperando os valores de volume maximo e volume atual
        int volumeMaximo = audioManager.getStreamMaxVolume(audioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(audioManager.STREAM_MUSIC);

        // Configurar o valores maximos para seekbar
        seekBarVolume.setMax(volumeMaximo);
        seekBarVolume.setProgress(volumeAtual);

        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(audioManager.STREAM_MUSIC, i, audioManager.FLAG_SHOW_UI);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}