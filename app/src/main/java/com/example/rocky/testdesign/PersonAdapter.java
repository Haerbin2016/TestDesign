package com.example.rocky.testdesign;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rocky on 2016/3/7.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder> {
    public  interface OnRecyclerViewItemClickListener{
        void onItemClick(int position);
        boolean onItemLongClick(int position);
    }
    public  OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener listener){
        this.mOnRecyclerViewItemClickListener = listener;
    }

    public List<String> dates = null;

    public PersonAdapter(List<String> dates) {
        this.dates = dates;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PersonAdapter.MyViewHolder holder, int position) {
            holder.text.setText(dates.get(position));
            MyViewHolder myViewHolder = (MyViewHolder)holder;
            myViewHolder.position = position;
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener,View.OnLongClickListener{

        public int position;
        public TextView text;
        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView)itemView.findViewById(R.id.text_item);
            View rootView = itemView.findViewById(R.id.recycle_view);
            rootView.setOnClickListener(MyViewHolder.this);
            rootView.setOnLongClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {

            if(null != mOnRecyclerViewItemClickListener){
                mOnRecyclerViewItemClickListener.onItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {

            if(null != mOnRecyclerViewItemClickListener){
                              return mOnRecyclerViewItemClickListener.onItemLongClick(position);
                         }
            return false;
        }
    }

}
