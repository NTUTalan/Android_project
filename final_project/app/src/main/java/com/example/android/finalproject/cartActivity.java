package com.example.android.finalproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class cartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private cartViewAdapter adapter;
    private final String count = "數量：";
    private TextView txtView;
    private Button btn_clean;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView = findViewById(R.id.rView);
        txtView = findViewById(R.id.textview_total);
        btn_clean = findViewById(R.id.btn_clean);
        btn_send = findViewById(R.id.btn_send);

        String[] items = this.getIntent().getStringArrayExtra("ItemString[]");
        ArrayList<Integer> counts = this.getIntent().getIntegerArrayListExtra("counts[]");
        ArrayList<Integer> prices = this.getIntent().getIntegerArrayListExtra("prices[]");

        LinkedList<String> itemTitle = new LinkedList<>();
        LinkedList<Integer> itemDescription = new LinkedList<>();

        for(int i = 0; i < items.length; i++) {
            itemTitle.add(items[i]);
            itemDescription.add(counts.get(i));
        }

        adapter = new cartViewAdapter(this, itemTitle, itemDescription, prices);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        txtView.setText("Total $ : " + String.valueOf(MainActivity.cart.getTotal()));
        Log.i("total", String.valueOf(MainActivity.cart.getTotal()));
        Toolbar toolbar = findViewById(R.id.cart_toolbar);
        toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void btn_send_Click(View view) {
        Toast.makeText(this, "結帳", Toast.LENGTH_LONG).show();
        MainActivity.cart.initialize();
        finish();
    }

    public void btn_clean_Click(View view) {
        Toast.makeText(this, "清空購物車", Toast.LENGTH_LONG).show();
        MainActivity.cart.initialize();
        finish();
    }


}