package com.example.jolyt.mobile_shop;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jolyt.mobile_shop.databinding.ContentMainBinding;

public class MainActivity extends AppCompatActivity {
private RecyclerView mRecyclerView;
private RecyclerView.Adapter mAdapter;
private RecyclerView.LayoutManager mLayoutManager;
public String[] MyDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ContentMainBinding)DataBindingUtil.setContentView(this,R.layout.content_main)).setViewModel(new MyViewModel());
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(MyDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}