package com.example.android.materialme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.sql.Struct;
import java.util.LinkedList;

public class cartActivity extends AppCompatActivity {
    private RecyclerView viewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        LinkedList<String> title = new LinkedList<>();
        LinkedList<String> description = new LinkedList<>();
    }
}