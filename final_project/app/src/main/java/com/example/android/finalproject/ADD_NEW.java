package com.example.android.finalproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class ADD_NEW extends AppCompatActivity {

    private EditText newTitle;
    private EditText newDes;
    private EditText newPrice;

    ArrayList<String> t = new ArrayList<>();
    ArrayList<String> d = new ArrayList<>();
    ArrayList<String> p = new ArrayList<>();
    /*public String t[];
    public String d[];
    public String p[];*/

    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        newTitle = findViewById(R.id.input_title);
        newDes = findViewById(R.id.input_description);
        newPrice = findViewById(R.id.input_price);

        Toolbar toolbar = findViewById(R.id.cart_toolbar);
        toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    public void addNewItem(View view) {

        t.add(newTitle.getText().toString());
        d.add(newDes.getText().toString());
        p.add(newPrice.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("title[]", newTitle.getText().toString());
        intent.putExtra("description[]", newDes.getText().toString());
        intent.putExtra("price[]", newPrice.getText().toString());

        this.startActivity(intent);

    }


}