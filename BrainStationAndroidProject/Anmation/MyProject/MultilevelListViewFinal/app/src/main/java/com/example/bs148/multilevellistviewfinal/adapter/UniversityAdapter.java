package com.example.bs148.multilevellistviewfinal.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.bs148.multilevellistviewfinal.R;
import com.example.bs148.multilevellistviewfinal.customdesign.CustomExpListView;
import com.example.bs148.multilevellistviewfinal.mapping.DepartmentAndStuddentMappings;
import com.example.bs148.multilevellistviewfinal.model.Department;
import com.example.bs148.multilevellistviewfinal.model.Student;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BS148 on 10/2/2016.
 */

public class UniversityAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<String> universityName;
    private HashMap<String, ArrayList<Department>> universityAndDepartment;

    public UniversityAdapter(Context context, ArrayList<String> universityName, HashMap<String, ArrayList<Department>> universityAndDepartment) {
        this.context = context;
        this.universityName = universityName;
        this.universityAndDepartment = universityAndDepartment;
    }

    @Override
    public int getGroupCount() {
        return this.universityName.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.universityName.get(groupPosition);
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
        String universityName = (String) this.getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.university_name_layout, parent, false);
        }
        TextView universityNameTextView = (TextView) convertView.findViewById(R.id.universityNameTextView);
        universityNameTextView.setTypeface(null, Typeface.BOLD);
        universityNameTextView.setTextColor(Color.CYAN);
        universityNameTextView.setText(universityName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final CustomExpListView departmentNameExpandableListView = new CustomExpListView(this.context);
        String universityName = (String) this.getGroup(groupPosition);
        ArrayList<String> departmentsName = new ArrayList<String>();
        departmentsName = DepartmentAndStuddentMappings.getSpecificDepartmentsName(universityName);
        HashMap<String, ArrayList<Student>> departmentAndStudents = new HashMap<String, ArrayList<Student>>();
        departmentAndStudents = DepartmentAndStuddentMappings.getDepartmentAndStudentMaping(universityName);

        DepartmentAdapter departmentAdapter = new DepartmentAdapter(context, universityName,departmentsName, departmentAndStudents);
        departmentNameExpandableListView.setAdapter(departmentAdapter);
        departmentNameExpandableListView.setGroupIndicator(null);
        return departmentNameExpandableListView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
