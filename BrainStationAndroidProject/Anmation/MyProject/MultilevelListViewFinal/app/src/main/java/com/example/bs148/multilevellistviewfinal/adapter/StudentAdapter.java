package com.example.bs148.multilevellistviewfinal.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.bs148.multilevellistviewfinal.R;
import com.example.bs148.multilevellistviewfinal.model.StudentInformation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BS148 on 10/2/2016.
 */

public class StudentAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<String> studentsName;
    private HashMap<String,StudentInformation> studentsAndInformation;

    public StudentAdapter(Context context, ArrayList<String> studentsName, HashMap<String, StudentInformation> studentsAndInformation) {
        this.context = context;
        this.studentsName = studentsName;
        this.studentsAndInformation = studentsAndInformation;
    }

    @Override
    public int getGroupCount() {
        try {
            return this.studentsName.size();
        }catch (Exception e){
            return 0;
        }

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        try {
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.studentsName.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.studentsAndInformation.get(this.studentsName.get(groupPosition));
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
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String studentName= (String) this.getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.student_name_layout, parent, false);
        }

        TextView studentNameTextView= (TextView) convertView.findViewById(R.id.studentNameTextView);
        studentNameTextView.setText(studentName);
        studentNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        studentNameTextView.setTextColor(Color.RED);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        StudentInformation studentInformation= (StudentInformation) this.getChild(groupPosition,childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.student_information_layout, parent, false);
        }
        TextView idTextView= (TextView) convertView.findViewById(R.id.idTextView);
        TextView cgpaTextView= (TextView) convertView.findViewById(R.id.cgpaTextView);
        idTextView.setText(studentInformation.getId());
        cgpaTextView.setText(studentInformation.getCgpa());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
