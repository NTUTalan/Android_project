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

/**
 *  RecyclerView 每一列的資料
 */
class Item {

    private String title;
    private String info;
    private int price;
    private final int imageResource;

    /**
     * Constructor for the Item data model.
     *
     * @param title The name if the item.
     * @param info Information about the item.
     */
    public Item(String title, String info, int imageResource ,int price) {
        this.title = title;
        this.info = info;
        this.price=price;
        this.imageResource = imageResource;
    }

    /**
     * 取得 Item 的 Title
     *
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }

    int getPrice() {
        return price;
    }

    /**
     * 取得 Item 的 info.
     */
    String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }

}
