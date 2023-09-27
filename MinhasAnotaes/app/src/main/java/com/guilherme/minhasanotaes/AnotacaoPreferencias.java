package com.guilherme.minhasanotaes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "anotacao";

    public AnotacaoPreferencias(Context context) {
        this.context = context;
        this.preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        this.editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao) {
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    public String recuperarAnotacao() {
        return preferences.getString(CHAVE_NOME, "");
    }
}
