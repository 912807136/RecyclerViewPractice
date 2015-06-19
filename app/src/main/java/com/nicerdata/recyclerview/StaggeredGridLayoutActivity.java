package com.nicerdata.recyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class StaggeredGridLayoutActivity extends ActionBarActivity {

    //声明
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private StaggeredAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        initDatas();
        initViews();

        mAdapter = new StaggeredAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        //设置RecyclerView的布局管理
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
    }

    private void initViews() {

        mRecyclerView = (RecyclerView) this.findViewById(R.id.id_recyclerView);
    }

    private void initDatas() {

        //赋值
        mDatas = new ArrayList<String>();

        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
