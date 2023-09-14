package com.guilherme.navigationdrawer.ui.contato;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContatoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ContatoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is contato fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}