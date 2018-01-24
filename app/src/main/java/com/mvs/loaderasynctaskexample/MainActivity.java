package com.mvs.loaderasynctaskexample;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Employee>>{

    private static final String TAG = MainActivity.class.getSimpleName();
    private EmpAdapter empAdapter;
    private ListView empListView;
    private static final int LOADER_ID=12345;
    private boolean loaderRunning=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initLoader(savedInstanceState);
    }



    private void initLoader(Bundle savedInstanceState) {
        /*if(savedInstanceState==null)
        {
            getSupportLoaderManager().initLoader(LOADER_ID,null,this).forceLoad();
            printLog("InitLoader");
        }
        else
        {
            getSupportLoaderManager().restartLoader(LOADER_ID,null,this);
            printLog("Restart loder");
        }*/
        getSupportLoaderManager().initLoader(LOADER_ID,null,this).forceLoad();
    }

    private void printLog(String initLoader) {
        Log.i(TAG,initLoader+"");
    }

    private void initViews() {
        empAdapter=new EmpAdapter(this,new ArrayList<Employee>());
        empListView=findViewById(R.id.lv_emp);
        empListView.setAdapter(empAdapter);

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        loaderRunning=true;
        printLog("OnCreateLoader");
        return new EmployeeLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Employee>> loader, List<Employee> data) {
        empAdapter.setEmployees((ArrayList<Employee>) data);
        loaderRunning=false;
        printLog("OnLoadFinished");
    }



    @Override
    public void onLoaderReset(Loader loader) {
        empAdapter.setEmployees(new ArrayList<Employee>());
        printLog("onLoaderReset");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        if(loaderRunning) {
            Loader loader = getSupportLoaderManager().getLoader(LOADER_ID);
        }
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
