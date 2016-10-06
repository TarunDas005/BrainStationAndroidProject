package com.example.bs148.expandablelistviewclicklistner;

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

public class MoviesAdapter extends BaseExpandableListAdapter {
    private Context context;
    private HashMap<String,ArrayList<ChildClass>> moviesCategory;
    private ArrayList<String> moviesList;

    public MoviesAdapter(Context context, HashMap<String, ArrayList<ChildClass>> moviesCategory, ArrayList<String> moviesList) {
        this.context = context;
        this.moviesCategory = moviesCategory;
        this.moviesList = moviesList;
    }

    @Override
    public int getGroupCount() {
        return moviesList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return moviesCategory.get(moviesList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return moviesList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return moviesCategory.get(moviesList.get(groupPosition)).get(childPosition );
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

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
        if(convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.parent_layout,parent,false);
        }
        TextView textView= (TextView) convertView.findViewById(R.id.parentText);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildClass childClass= (ChildClass) this.getChild(groupPosition,childPosition);
        if(convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.child_layout,parent,false);
        }
        TextView textView= (TextView) convertView.findViewById(R.id.childText);
        textView.setText(childClass.getName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
