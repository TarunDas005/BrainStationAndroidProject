package com.example.bs148.draglistviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BS148 on 9/25/2016.
 */

public class CustomAdapter extends BaseAdapter{
    Context context;
    private ArrayList<ListMenu> listMenus;
    private static LayoutInflater inflater = null;

    public CustomAdapter(MainActivity mainActivity, ArrayList<ListMenu> listMenus) {
        context = mainActivity;
        this.listMenus = listMenus;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listMenus.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void remove(int position) {
        listMenus.remove(position);
        notifyDataSetChanged();
    }

    public class Holder {
        TextView tv;
        ImageView img;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.raw_list, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView);
        holder.img=(ImageView) rowView.findViewById(R.id.imageview);
        holder.tv.setText(listMenus.get(position).getName());
        holder.img.setImageResource(listMenus.get(position).getImageId());
        return rowView;
    }
}
