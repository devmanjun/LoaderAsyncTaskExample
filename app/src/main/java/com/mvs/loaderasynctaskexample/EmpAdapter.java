package com.mvs.loaderasynctaskexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24-Jan-18.
 */

public class EmpAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context mContext;
    private ArrayList<Employee> employees=new ArrayList<Employee>();

    public EmpAdapter(Context mContext, ArrayList<Employee> employees) {
        this.mContext=mContext;
        this.employees.addAll(employees);
        inflater= LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Employee emp= (Employee) getItem(position);
        if (convertView==null)
        {
            convertView=inflater.inflate(R.layout.emp_list_item,null);
        }

        TextView idTextView,nameTextView;
        idTextView=convertView.findViewById(R.id.tv_id);
        idTextView.setText(emp.getId()+"");
        nameTextView=convertView.findViewById(R.id.tv_name);
        nameTextView.setText(emp.getName()+"");

        return convertView;
    }

    public void setEmployees(ArrayList<Employee> empNewList)
    {
        employees.clear();
        employees.addAll(empNewList);
        notifyDataSetChanged();

    }
}
