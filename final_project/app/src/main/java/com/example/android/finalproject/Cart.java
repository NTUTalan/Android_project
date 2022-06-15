package com.example.android.finalproject;

import java.util.ArrayList;

public class Cart {
    public ArrayList<String> cartItem;
    public ArrayList<Integer> cartCount; //加入購物車的次數ArrayList
    public ArrayList<Integer> cost;


    public Cart() {
        cartItem = new ArrayList<>();
        cartCount = new ArrayList<>();
        cost = new ArrayList<>();
        cartItem.clear();
        cartCount.clear();
        cost.clear();
    }

    public void Add(String item, int price) {
        for(int i =  0; i < cartItem.size(); i++) {
            if(cartItem.get(i) == item) {
                return;
            }
        }
        cartItem.add(item);
        cartCount.add(0);
        cost.add(price);
    }

    public void addCount(String item) {
        int index;
        for(index = 0; index < cartItem.size(); index++) {
            if(cartItem.get(index) == item){
                break;
            }
        }
        cartCount.set(index, cartCount.get(index) + 1);
    }

    public int getTotal() {
        int total = 0;
        for(int i =  0; i < cartItem.size(); i++) {
            total += cartCount.get(i) * cost.get(i);
        }
        return total;
    }

    public void initialize() {
        cartItem.clear();
        cartCount.clear();
        cost.clear();
    }
}
