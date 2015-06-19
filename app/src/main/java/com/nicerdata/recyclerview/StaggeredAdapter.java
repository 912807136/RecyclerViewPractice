package com.nicerdata.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Administrator
 * Date 2015/6/19.
 */
public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;

    private List<Integer> mHeights;

    //构造方法
    public StaggeredAdapter(Context context, List<String> datas) {
        //成员变量进行赋值
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);
        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    /*
    创建ViewHolder
     */
    @Override
    public StaggeredAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = mInflater.inflate(R.layout.item_single_textview, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    /*
    绑定ViewHolder的数据
     */
    @Override
    public void onBindViewHolder(StaggeredAdapter.MyViewHolder myViewHolder, int pos) {
        ViewGroup.LayoutParams lp = myViewHolder.itemView.getLayoutParams();
        lp.height = mHeights.get(pos);
        myViewHolder.itemView.setLayoutParams(lp);
        myViewHolder.tv.setText(mDatas.get(pos));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        //当前item的所有的控件
        TextView tv;

        public MyViewHolder(View v) {
            super(v);
            tv = (TextView) v.findViewById(R.id.id_tv);
        }
    }
}


