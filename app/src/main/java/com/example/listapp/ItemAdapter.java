package com.example.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listapp.R;

import org.w3c.dom.Text;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater minflater;
    String[] fruits;
    String[] prices;
    String[] descriptions;

    public ItemAdapter(Context c, String [] f, String [] p, String [] d){
        fruits = f;
        prices= p;
        descriptions = d;
        minflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return fruits.length;
    }

    @Override
    public Object getItem(int position) {
        return fruits[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = minflater.inflate(R.layout.my_listview_detail,null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nametextView);
        TextView pricetextView = (TextView) v.findViewById(R.id.pricetextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptiontextView);

        String name = fruits[position];
        String desc = descriptions[position];
        String cost = prices[position];

        nameTextView.setText(name);
        pricetextView.setText(cost);
        descriptionTextView.setText(desc);

        return v;
    }
}
