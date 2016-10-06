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
import com.example.bs148.multilevellistviewfinal.customdesign.CustomExpListView;
import com.example.bs148.multilevellistviewfinal.mapping.StudentAndInformationMapping;
import com.example.bs148.multilevellistviewfinal.model.Department;
import com.example.bs148.multilevellistviewfinal.model.Student;
import com.example.bs148.multilevellistviewfinal.model.StudentInformation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BS148 on 10/2/2016.
 */

public class DepartmentAdapter extends BaseExpandableListAdapter {
    private Context context;
    private String universityName;
    private ArrayList<String> departmentName;
    private HashMap<String,ArrayList<Student>> departmentAndStudent;

    public DepartmentAdapter(Context context,String universityName, ArrayList<String> departmentName, HashMap<String, ArrayList<Student>> departmentAndStudent) {
        this.context = context;
        this.universityName=universityName;
        this.departmentName = departmentName;
        this.departmentAndStudent = departmentAndStudent;
    }

    @Override
    public int getGroupCount() {
        try {
            return this.departmentName.size();
        }catch (Exception e){
            return 0;
        }

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.departmentName.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childPosition;
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
        String departmentName = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.department_name_layout, parent, false);
        }
        TextView departmentNameTextView = (TextView) convertView
                .findViewById(R.id.departmentNameTextView);
        departmentNameTextView.setText(departmentName);
        departmentNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        departmentNameTextView.setTextColor(Color.YELLOW);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final CustomExpListView studentExpandableListView = new CustomExpListView(this.context);
        String departmentName=(String) this.getGroup(groupPosition);
        HashMap<String,StudentInformation> studentAndInformations=new HashMap<String,StudentInformation>();
        studentAndInformations= StudentAndInformationMapping.getStudentAndInformation(universityName,departmentName);
        ArrayList<String> studentsName=new ArrayList<String>();
        studentsName=StudentAndInformationMapping.getSpecificStudentsName(universityName,departmentName);
        StudentAdapter studentAdapter=new StudentAdapter(context,studentsName,studentAndInformations);
        studentExpandableListView.setAdapter(studentAdapter);
        studentExpandableListView.setGroupIndicator(null);
        return studentExpandableListView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
