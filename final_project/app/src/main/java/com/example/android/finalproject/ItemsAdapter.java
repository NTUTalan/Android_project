/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.finalproject;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/***
 * The adapter class for the RecyclerView, contains the Item data.
 */
class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>  {

    // Member variables.
    private ArrayList<Item> itemData;
    private ArrayList<Integer> count;
    private Context mContext;

    /**
     * Constructor.
     * @param Data ArrayList containing the Item data.
     * @param context Context of the application.
     */
    ItemsAdapter(Context context, ArrayList<Item> Data) {
        this.itemData = Data;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.context = mContext;
        return viewHolder;
    }

    /**
     * Required method that binds the data to the viewholder.
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(ItemsAdapter.ViewHolder holder, int position) {
        // Get current sport.
        Item currentItem = itemData.get(position);
        holder.setPosition(position);
        holder.setItem(currentItem);
        // Populate the textviews with data.
        holder.bindTo(currentItem);
    }

    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return itemData.size();
    }


    /**
     *  RecyclerView 的 ViewHolder.
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;
        private TextView mprice;
        private Button btn;
        private Item curr;
        private int pos;
        public Context context;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);
            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mSportsImage = itemView.findViewById(R.id.sportsImage);
            mprice = itemView.findViewById(R.id.price_view);
            btn = itemView.findViewById(R.id.btn_add);
            //Add to Cart 按鈕的 OnClick
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "已新增物品到購物車", Toast.LENGTH_LONG).show();
                    MainActivity.cart.Add(curr.getTitle(), curr.getPrice());
                    MainActivity.cart.addCount(curr.getTitle());
                }
            });
            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(Item currentItem){
            // Populate the textviews with data.
            mTitleText.setText(currentItem.getTitle());
            mInfoText.setText(currentItem.getInfo());
            mprice.setText("Price:" + String.valueOf(currentItem.getPrice())+"$");

            // Load the images into the ImageView using the Glide library.
            Glide.with(mContext).load(
                    currentItem.getImageResource()).into(mSportsImage);
        }

        void setPosition(int i) {
            this.pos = i;
        }

        void setItem(Item item) {
            this.curr = item;
        }

        /**
         * Handle click to show DetailActivity.
         *
         * @param view View that is clicked.
         */
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View view) {
            Item currentItem = itemData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentItem.getTitle());
            detailIntent.putExtra("image_resource",
                    currentItem.getImageResource());
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext,mSportsImage,"SportImage");
            mContext.startActivity(detailIntent, options.toBundle());
        }
    }
}
