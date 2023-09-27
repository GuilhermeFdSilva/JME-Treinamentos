package com.guilherme.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.guilherme.aprendaingles.R;

public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageView imageDog, imageCat, imageLion, imageMonkey, imageSheep, imageCow;
    private MediaPlayer mediaPlayer;

    public BichosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        imageDog = view.findViewById(R.id.imageDog);
        imageCat = view.findViewById(R.id.imageCat);
        imageLion = view.findViewById(R.id.imageLion);
        imageMonkey = view.findViewById(R.id.imageMonkey);
        imageSheep = view.findViewById(R.id.imageSheep);
        imageCow = view.findViewById(R.id.imageCow);

        imageDog.setOnClickListener(this);
        imageCat.setOnClickListener(this);
        imageLion.setOnClickListener(this);
        imageMonkey.setOnClickListener(this);
        imageSheep.setOnClickListener(this);
        imageCow.setOnClickListener(this);

        return view;
    }

    private void tocarSom(int som){
        mediaPlayer = MediaPlayer.create(getActivity(), som);
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.imageDog) {
            tocarSom(R.raw.bicho_dog);
        } else if (viewId == R.id.imageCat) {
            tocarSom(R.raw.bicho_cat);
        } else if (viewId == R.id.imageLion) {
            tocarSom(R.raw.bicho_lion);
        } else if (viewId == R.id.imageMonkey) {
            tocarSom(R.raw.bicho_monkey);
        } else if (viewId == R.id.imageSheep) {
            tocarSom(R.raw.bicho_sheep);
        } else if (viewId == R.id.imageCow) {
            tocarSom(R.raw.bicho_cow);
        }
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}