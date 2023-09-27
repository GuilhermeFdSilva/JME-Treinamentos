package com.guilherme.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.guilherme.aprendaingles.R;

public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageView imageOne, imageTwo, imageThree, imageFour, imageFive, imageSix;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imageOne = view.findViewById(R.id.imageOne);
        imageTwo = view.findViewById(R.id.imageTwo);
        imageThree = view.findViewById(R.id.imageThree);
        imageFour = view.findViewById(R.id.imageFour);
        imageFive = view.findViewById(R.id.imageFive);
        imageSix = view.findViewById(R.id.imageSix);

        imageOne.setOnClickListener(this);
        imageTwo.setOnClickListener(this);
        imageThree.setOnClickListener(this);
        imageFour.setOnClickListener(this);
        imageFive.setOnClickListener(this);
        imageSix.setOnClickListener(this);

        return view;
    }

    private void tocarSom(int som) {
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
        if (viewId == R.id.imageOne) {
            tocarSom(R.raw.numero_one);
        } else if (viewId == R.id.imageTwo) {
            tocarSom(R.raw.numero_two);
        } else if (viewId == R.id.imageThree) {
            tocarSom(R.raw.numero_three);
        } else if (viewId == R.id.imageFour) {
            tocarSom(R.raw.numero_four);
        } else if (viewId == R.id.imageFive) {
            tocarSom(R.raw.numero_five);
        } else if (viewId == R.id.imageSix) {
            tocarSom(R.raw.numero_six);
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