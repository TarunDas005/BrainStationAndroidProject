package com.example.bs148.navigationdrawerexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.NavigationViewHolder> {

    String title[];
    int icon[];
    private final int TYPE_HEADER=0;
    private final int TYPE_ITEM=1;
    public NavigationDrawerAdapter(int icon[],String title[]) {
        this.title=title;
        this.icon=icon;
    }

    @Override
    public NavigationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if(viewType==TYPE_HEADER){
           View headerView= LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_header_layout,parent,false);
           NavigationViewHolder holderHeader=new NavigationViewHolder(headerView,TYPE_HEADER);
           return holderHeader;
       }else if(viewType==TYPE_ITEM){
           View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_list_row,parent,false);
           NavigationViewHolder itemHolder=new NavigationViewHolder(view,TYPE_ITEM);
           return itemHolder;
       }

        return null;
    }

    @Override
    public void onBindViewHolder(NavigationViewHolder holder, int position) {
        if(holder.holderType==TYPE_HEADER){
            holder.headerImage.setImageResource(R.drawable.header);
        }else{
            holder.itemImage.setImageResource(icon[position-1]);
            holder.itemText.setText(title[position-1]);
        }
    }

    @Override
    public int getItemCount() {
        return title.length+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==TYPE_HEADER){
            return TYPE_HEADER;
        }else{
            return TYPE_ITEM;
        }
    }

    public class NavigationViewHolder extends RecyclerView.ViewHolder{

        ImageView headerImage;
        ImageView itemImage;
        TextView itemText;
        int holderType;
        public NavigationViewHolder(View itemView,int viewType) {
            super(itemView);

            if(viewType==TYPE_HEADER){
                headerImage= (ImageView) itemView.findViewById(R.id.headerImage);
                holderType=TYPE_HEADER;
            }else if(viewType==TYPE_ITEM){
                itemImage= (ImageView) itemView.findViewById(R.id.rowIcon);
                itemText= (TextView) itemView.findViewById(R.id.rowText);
                holderType=TYPE_ITEM;
            }
        }
    }
}
