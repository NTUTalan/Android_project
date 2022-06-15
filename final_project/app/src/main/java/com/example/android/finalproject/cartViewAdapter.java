package com.example.android.finalproject;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class cartViewAdapter extends RecyclerView.Adapter<cartViewAdapter.cartViewholder> {

    private final LayoutInflater mInflater;
    private final LinkedList<String> itemTitle;
    private final LinkedList<Integer> itemDescription;
    private final ArrayList<Integer> prices;
    private static String count = "數量：";
    public final Context context;

    //Holder class
    class cartViewholder extends RecyclerView.ViewHolder {

        public final TextView wordItemView;
        public final TextView subwordItemView;
        public final TextView costView;
        public final Context context;
        final cartViewAdapter mAdapter;

        public cartViewholder(View itemView, cartViewAdapter adapter, Context context) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            subwordItemView = itemView.findViewById(R.id.subword);
            costView = itemView.findViewById(R.id.cost);
            this.context = context;
            this.mAdapter = adapter;
        }
    }

    public cartViewAdapter(Context context, LinkedList<String> title, LinkedList<Integer> subtitle, ArrayList<Integer> P) {
        mInflater = LayoutInflater.from(context);
        this.itemTitle = title;
        this.itemDescription = subtitle;
        this.prices = P;
        this.context = context;
    }

    @NonNull
    @Override
    public cartViewAdapter.cartViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recycle_layout, parent, false);
        return new cartViewholder(mItemView, this, context);
    }

    @Override
    public void onBindViewHolder(cartViewAdapter.cartViewholder holder, int position) {
        String title = itemTitle.get(position);
        String subtitle = count + String.valueOf(itemDescription.get(position));
        holder.wordItemView.setText(title);
        holder.subwordItemView.setText(subtitle);
        int cost = itemDescription.get(position) * prices.get(position);
        holder.costView.setText("價格：" + String.valueOf(cost));
    }

    @Override
    public int getItemCount() {
        return itemTitle.size();
    }
}
