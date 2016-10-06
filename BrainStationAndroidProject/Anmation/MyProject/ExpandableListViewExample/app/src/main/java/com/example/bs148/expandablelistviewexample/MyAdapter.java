package com.example.bs148.expandablelistviewexample;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BS148 on 9/26/2016.
 */

public class MyAdapter extends BaseExpandableListAdapter {

    private ArrayList<String>headerTitles;
    private HashMap<String,ArrayList<String>> childTitles;
    private Context context;

    public MyAdapter(Context context, ArrayList<String> headerTitles, HashMap<String, ArrayList<String>> childTitles) {
        this.context = context;
        this.headerTitles = headerTitles;
        this.childTitles = childTitles;
    }

    // this method returns how many parent item
    @Override
    public int getGroupCount() {
        return headerTitles.size();
    }

    //the number of child item available in each heading
    @Override
    public int getChildrenCount(int groupPosition) {
        return childTitles.get(headerTitles.get(groupPosition)).size();
    }

    //pass the current object avalable in group
    @Override
    public Object getGroup(int groupPosition) {
        return headerTitles.get(groupPosition);
    }

    //return child object of particular hading
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childTitles.get(headerTitles.get(groupPosition)).get(childPosition);
    }

    //return parent position
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //return child position
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title= (String) this.getGroup(groupPosition);
        if (convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.parent_layout,null);
        }
        TextView textView= (TextView) convertView.findViewById(R.id.headingItem);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title= (String) this.getChild(groupPosition,childPosition);
        if(convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.child_layout,null);
        }
        TextView textView= (TextView) convertView.findViewById(R.id.child_item);
        textView.setText(title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
