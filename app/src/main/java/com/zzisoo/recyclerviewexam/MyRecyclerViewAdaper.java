package com.zzisoo.recyclerviewexam;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yangjisoo on 15. 9. 23..
 */
public class MyRecyclerViewAdaper extends RecyclerView.Adapter<MyRecyclerViewAdaper.ViewHodler> {

    private ArrayList<MyData> mDatas;

    public void setMyDatas(ArrayList<MyData> arrMyDatas){
        mDatas = arrMyDatas;
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        View mvBackground;
        TextView mtvTitle;

        public View getMvBackground() {
            return mvBackground;
        }

        public TextView getMtvTitle() {
            return mtvTitle;
        }

        public ViewHodler(View itemView) {
            super(itemView);
            mvBackground = itemView.findViewById(R.id.item_background);
            mtvTitle = (TextView) itemView.findViewById(R.id.item_title);
        }
    }

    @Override
    public MyRecyclerViewAdaper.ViewHodler onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new item view
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item, null);

        // create ViewHolder
        MyRecyclerViewAdaper.ViewHodler viewHolder = new MyRecyclerViewAdaper.ViewHodler(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdaper.ViewHodler viewHodler, int i) {
        // set Item with Data(Bind)
        MyData myData = mDatas.get(i);
        viewHodler.getMtvTitle().setText(myData.mText);
        viewHodler.getMvBackground().setBackgroundColor(Color.parseColor(myData.mColor));
        viewHodler.itemView.setLayoutParams(new FrameLayout.LayoutParams(myData.mWidth, myData.mHeight));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


}
