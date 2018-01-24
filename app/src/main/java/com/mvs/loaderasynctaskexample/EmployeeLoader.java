package com.mvs.loaderasynctaskexample;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24-Jan-18.
 */

public class EmployeeLoader extends AsyncTaskLoader<List<Employee>> {
    public EmployeeLoader(Context context) {
        super(context);
    }

    @Override
    public List<Employee> loadInBackground() {

        List<Employee> empList=new ArrayList<Employee>();
        for(int i=0;i<10;i++)
        {
            Employee empObj=new Employee(i,"Employee"+i);
            empList.add(empObj);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return empList;
    }
}
