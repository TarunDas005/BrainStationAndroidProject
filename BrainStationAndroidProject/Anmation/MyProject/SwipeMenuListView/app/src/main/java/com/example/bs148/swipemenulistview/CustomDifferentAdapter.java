package com.example.bs148.swipemenulistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BS148 on 9/26/2016.
 */

public class CustomDifferentAdapter extends BaseAdapter {
    Context context;
    private ArrayList<ListMenu> listMenus;
    private static LayoutInflater inflater = null;

    public CustomDifferentAdapter(Context context, ArrayList<ListMenu> listMenus) {
        this.context = context;
        this.listMenus = listMenus;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getViewTypeCount() {
        // menu type count
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        // current menu type
        return position % 3;
    }
    @Override
    public int getCount() {
        return listMenus.size();
    }

    @Override
    public Object getItem(int position) {
        return listMenus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Holder {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView =inflater.inflate(R.layout.item_list_app, null);
            new ViewHolder(convertView);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.tv.setText(listMenus.get(position).getName());
        holder.img.setImageResource(listMenus.get(position).getImageId());
        return convertView;
    }

    class ViewHolder {
        TextView tv;
        ImageView img;

        public ViewHolder(View view) {
            img = (ImageView) view.findViewById(R.id.imageview);
            tv = (TextView) view.findViewById(R.id.textView);
            view.setTag(this);
        }
    }
}
