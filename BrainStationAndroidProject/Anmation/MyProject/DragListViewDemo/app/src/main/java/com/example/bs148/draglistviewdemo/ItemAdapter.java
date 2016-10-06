package com.example.bs148.draglistviewdemo;

import android.content.Context;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.woxthebox.draglistview.DragItem;
import com.woxthebox.draglistview.DragItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BS148 on 9/25/2016.
 */
public class ItemAdapter extends DragItemAdapter<Pair<Long, ListMenu>, ItemAdapter.ViewHolder> {

    private int mLayoutId;
    private int mGrabHandleId;

    public ItemAdapter(ArrayList<Pair<Long, ListMenu>> list, int layoutId, int grabHandleId, boolean dragOnLongPress) {
        super(dragOnLongPress);
        mLayoutId = layoutId;
        mGrabHandleId = grabHandleId;
        setHasStableIds(true);
        setItemList(list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.textView.setText(mItemList.get(position).second.getName());
        holder.imageView.setImageResource(mItemList.get(position).second.getImageId());
        holder.itemView.setTag(mItemList.get(position).second);
    }

    @Override
    public long getItemId(int position) {
        return mItemList.get(position).first;
    }

    public class ViewHolder extends DragItemAdapter<Pair<Long, ListMenu>, ItemAdapter.ViewHolder>.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(final View itemView) {
            super(itemView, mGrabHandleId);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView= (ImageView) itemView.findViewById(R.id.imageview);
        }

        @Override
        public void onItemClicked(View view) {
            Toast.makeText(view.getContext(), "Item clicked", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onItemLongClicked(View view) {
            Toast.makeText(view.getContext(), "Item long clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
