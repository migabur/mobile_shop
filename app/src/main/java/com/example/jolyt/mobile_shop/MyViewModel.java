package com.example.jolyt.mobile_shop;

import android.databinding.ObservableField;

import java.util.Observable;

public class MyViewModel {
    public final ObservableField<String> mainTextTest = new ObservableField<>();
    public final ObservableField<String> idRecyclerView = new ObservableField<>();

    public MyViewModel(){
        mainTextTest.set("je suis une andouille de veau");
        idRecyclerView.set("mainRecyclerView");
    }
}
