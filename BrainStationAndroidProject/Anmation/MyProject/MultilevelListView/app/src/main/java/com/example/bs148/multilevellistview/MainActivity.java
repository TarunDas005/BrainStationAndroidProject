package com.example.bs148.multilevellistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Items> mainList;
    private ArrayList<Items.SubCategory>subArrayList1;
    private ArrayList<Items.SubCategory>subArrayList2;
    private LinearLayout mLinearListView;
    boolean isFirstViewClick=false;
    boolean isSecondViewClick=false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinearListView = (LinearLayout) findViewById(R.id.linear_ListView);

        //Make array list one is for mainlist and other is for sublist
        mainList=new ArrayList<Items>();
        subArrayList1=new ArrayList<Items.SubCategory>();
        subArrayList2=new ArrayList<Items.SubCategory>();

        //This arraylists are used to put items in sublists
        ArrayList<Items.SubCategory.ItemList> subArrayListItem1=new ArrayList<Items.SubCategory.ItemList>();
        ArrayList<Items.SubCategory.ItemList> subArrayListItem2=new ArrayList<Items.SubCategory.ItemList>();
        ArrayList<Items.SubCategory.ItemList> subArrayListItem3=new ArrayList<Items.SubCategory.ItemList>();

        //Add main categories in Mainlists along with their items it
        mainList.add(new Items("Mobiles", subArrayList1));
        mainList.add(new Items("Accessories", subArrayList2));

        //Add arrylist in category
        subArrayList1.add(new Items.SubCategory("Motorola", subArrayListItem1));

        //Add items means arrylist
        subArrayListItem1.add(new Items.SubCategory.ItemList("Moto X", "29999"));
        subArrayListItem1.add(new Items.SubCategory.ItemList("Moto G", "12999"));
        subArrayListItem1.add(new Items.SubCategory.ItemList("Moto E", "6999"));


        subArrayList2.add(new Items.SubCategory("Covers", subArrayListItem2));
        subArrayList2.add(new Items.SubCategory("Headphones", subArrayListItem3));


        subArrayListItem2.add(new Items.SubCategory.ItemList("FlipCover", "599"));
        subArrayListItem2.add(new Items.SubCategory.ItemList("pouch", "249"));
        subArrayListItem2.add(new Items.SubCategory.ItemList("BackCover", "499"));

        subArrayListItem3.add(new Items.SubCategory.ItemList("Wired Headphones", "399"));
        subArrayListItem3.add(new Items.SubCategory.ItemList("Wireless Headphones", "1999"));



        //Adds data into first row
        for (int i = 0; i < mainList.size(); i++)
        {

            LayoutInflater inflater = null;
            inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mLinearView = inflater.inflate(R.layout.row_first, null);

            final TextView mProductName = (TextView) mLinearView.findViewById(R.id.textViewName);
            final RelativeLayout mLinearFirstArrow=(RelativeLayout)mLinearView.findViewById(R.id.linearFirst);
            final ImageView mImageArrowFirst=(ImageView)mLinearView.findViewById(R.id.imageFirstArrow);
            final LinearLayout mLinearScrollSecond=(LinearLayout)mLinearView.findViewById(R.id.linear_scroll);

            //checkes if menu is already opened or not
            if(isFirstViewClick==false)
            {
                mLinearScrollSecond.setVisibility(View.GONE);
                mImageArrowFirst.setBackgroundResource(R.drawable.arw_lt);
            }
            else
            {
                mLinearScrollSecond.setVisibility(View.VISIBLE);
                mImageArrowFirst.setBackgroundResource(R.drawable.arw_down);
            }
            //Handles onclick effect on list item
            mLinearFirstArrow.setOnTouchListener(new View.OnTouchListener()
            {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {

                    if(isFirstViewClick==false)
                    {
                        isFirstViewClick=true;
                        mImageArrowFirst.setBackgroundResource(R.drawable.arw_down);
                        mLinearScrollSecond.setVisibility(View.VISIBLE);

                    }
                    else
                    {
                        isFirstViewClick=false;
                        mImageArrowFirst.setBackgroundResource(R.drawable.arw_lt);
                        mLinearScrollSecond.setVisibility(View.GONE);
                    }
                    return false;
                }
            });


            final String name = mainList.get(i).getpName();
            mProductName.setText(name);

            //Adds data into second row
            for (int j = 0; j < mainList.get(i).getmSubCategoryList().size(); j++)
            {
                LayoutInflater inflater2 = null;
                inflater2 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View mLinearView2 = inflater2.inflate(R.layout.row_second, null);

                TextView mSubItemName = (TextView) mLinearView2.findViewById(R.id.textViewTitle);
                final RelativeLayout mLinearSecondArrow=(RelativeLayout)mLinearView2.findViewById(R.id.linearSecond);
                final ImageView mImageArrowSecond=(ImageView)mLinearView2.findViewById(R.id.imageSecondArrow);
                final LinearLayout mLinearScrollThird=(LinearLayout)mLinearView2.findViewById(R.id.linear_scroll_third);

                //checkes if menu is already opened or not
                if(isSecondViewClick==false)
                {
                    mLinearScrollThird.setVisibility(View.GONE);
                    mImageArrowSecond.setBackgroundResource(R.drawable.arw_lt);
                }
                else
                {
                    mLinearScrollThird.setVisibility(View.VISIBLE);
                    mImageArrowSecond.setBackgroundResource(R.drawable.arw_down);
                }
                //Handles onclick effect on list item
                mLinearSecondArrow.setOnTouchListener(new View.OnTouchListener()
                {
                    @Override
                    public boolean onTouch(View v, MotionEvent event)
                    {
                        if(isSecondViewClick==false)
                        {
                            isSecondViewClick=true;
                            mImageArrowSecond.setBackgroundResource(R.drawable.arw_down);
                            mLinearScrollThird.setVisibility(View.VISIBLE);

                        }
                        else
                        {
                            isSecondViewClick=false;
                            mImageArrowSecond.setBackgroundResource(R.drawable.arw_lt);
                            mLinearScrollThird.setVisibility(View.GONE);
                        }
                        return false;
                    }
                });


                final String catName = mainList.get(i).getmSubCategoryList().get(j).getpSubCatName();
                mSubItemName.setText(catName);
                //Adds items in subcategories
                for (int k = 0; k < mainList.get(i).getmSubCategoryList().get(j).getmItemListArray().size(); k++)
                {
                    LayoutInflater inflater3 = null;
                    inflater3 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mLinearView3 = inflater3.inflate(R.layout.row_third, null);

                    TextView mItemName = (TextView) mLinearView3.findViewById(R.id.textViewItemName);
                    TextView mItemPrice = (TextView) mLinearView3.findViewById(R.id.textViewItemPrice);
                    final String itemName = mainList.get(i).getmSubCategoryList().get(j).getmItemListArray().get(k).getItemName();
                    final String itemPrice = mainList.get(i).getmSubCategoryList().get(j).getmItemListArray().get(k).getItemPrice();
                    mItemName.setText(itemName);
                    mItemPrice.setText(itemPrice);

                    mLinearScrollThird.addView(mLinearView3);
                }

                mLinearScrollSecond.addView(mLinearView2);

            }

            mLinearListView.addView(mLinearView);
        }
    }
}
