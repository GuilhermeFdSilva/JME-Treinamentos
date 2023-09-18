package com.guilherme.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guilherme.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class SobreFragment extends Fragment {
    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String descricao = "A ATM Consultoria tem como missão apoiar organizações " +
                "que desejam alcançar o sucesso através da exelência em gestão e " +
                "da busca pela qualidade.";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage(getActivity(),false)
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um e-mail")
                .addWebsite("https://google.com/", "Acesse nosso site")

                .addGroup("Redes sociais")
                .addFacebook("", "Facebook")
                .addInstagram("", "Instagram")
                .addTwitter("", "Twitter")
                .addGitHub("GuilhermeFdSilva", "GitHub")
                .addPlayStore("com.facebook.katana", "Dowload App")

                .addItem(versao)

                .create();

        // return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}