package com.example.nz.expandablelistviewthree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Nz on 2/25/2019.
 */

public class CustomAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> headerList;
    HashMap<String,List<String>> childSlist;

    public CustomAdapter(Context context, List<String> headerList, HashMap<String, List<String>> childSlist) {
        this.context = context;
        this.headerList = headerList;
        this.childSlist = childSlist;
    }

    @Override
    public int getGroupCount() {
        return headerList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childSlist.get(headerList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headerList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childSlist.get(headerList.get(groupPosition)).get(childPosition);
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

        String headrValue = (String) getGroup(groupPosition);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(R.layout.headar_layout,null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.headerText);
        textView.setText(headrValue);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String childValue = (String) getChild(groupPosition,childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout,null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.chiltTextView);
        textView.setText(childValue);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
