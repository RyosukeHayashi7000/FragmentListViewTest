package com.example.flagmentlisttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
        Context context;
        LayoutInflater layoutInflater;
        ArrayList<Food> foodList;

        public ListAdapter(Context context) {
            this.context = context;
            //this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.layoutInflater = LayoutInflater.from(context);
        }

        public void setFoodList(ArrayList<Food> foodList) {
            this.foodList = foodList;
        }

        @Override
        public int getCount() {
            return foodList.size();
        }

        @Override
        public Object getItem(int position) {
            return foodList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return foodList.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
            }

            ((TextView) convertView.findViewById(R.id.item_textView1)).setText(foodList.get(position).getName());
            ((TextView)convertView.findViewById(R.id.item_textView2)).setText(String.valueOf(foodList.get(position).getPrice())+"円");

            return convertView;
        }
}
