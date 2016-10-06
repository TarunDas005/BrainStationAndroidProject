package com.example.bs148.draglistviewdemo;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.woxthebox.draglistview.DragItem;
import com.woxthebox.draglistview.DragListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ListMenu>listMenus;
    ArrayList<Pair<Long, ListMenu>> list;
    private MySwipeRefreshLayout mRefreshLayout;
    DragListView listView;
    public static int [] prgmImages={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript","Python"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (DragListView) findViewById(R.id.listView);
        listMenus=new ArrayList<ListMenu>();
        mRefreshLayout = (MySwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        list = new ArrayList<>();
        for(int i=0;i<prgmImages.length;i++){
            ListMenu listMenu=new ListMenu(prgmImages[i],prgmNameList[i]);
            listMenus.add(listMenu);
            list.add(new Pair<>(Long.valueOf(i), listMenu));
        }

        listView.setDragListListener(new DragListView.DragListListener() {
            @Override
            public void onItemDragStarted(int position) {
                mRefreshLayout.setEnabled(false);
                Toast.makeText(getApplicationContext(), "Start - position: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemDragging(int itemPosition, float x, float y) {

            }

            @Override
            public void onItemDragEnded(int fromPosition, int toPosition) {
                mRefreshLayout.setEnabled(true);
                if (fromPosition != toPosition) {
                    Toast.makeText(getApplicationContext(), "End - position: " + toPosition, Toast.LENGTH_SHORT).show();
                }
            }
        });
        listView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ItemAdapter listAdapter = new ItemAdapter(list, R.layout.raw_list, R.id.imageview, false);
        listView.setAdapter(listAdapter,true);
        listView.setCanDragHorizontally(false);

        //for refreshing layout
        mRefreshLayout.setScrollingView(listView.getRecyclerView());
        mRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });

        //can not drag or drop at specific position
        listView.setCanNotDragAboveTopItem(true);
        listView.setCanNotDragBelowBottomItem(true);

        // Set a callback so you can decide exactly which positions that is allowed to drag from and drop to
        listView.setDragListCallback(new DragListView.DragListCallbackAdapter() {
            @Override
            public boolean canDragItemAtPosition(int dragPosition) {
                // Can not drag item at position 5
                return dragPosition != 5;
            }

            @Override
            public boolean canDropItemAtPosition(int dropPosition) {
                // Can not drop item at position 2
                return dropPosition != 2;
            }
        });

        //for custom drag change text
        listView.setCustomDragItem(new MyDragItem(getApplicationContext(), R.layout.raw_list));


        //can not reorder if use this line
        /*listView.setDisableReorderWhenDragging(true);*/

    }


    private static class MyDragItem extends DragItem {
        public MyDragItem(Context context, int layoutId) {
            super(context, layoutId);
        }

        @Override
        public void onBindDragView(View clickedView, View dragView) {
            CharSequence text = ((TextView) clickedView.findViewById(R.id.textView)).getText();
            ((TextView) dragView.findViewById(R.id.textView)).setText(text);
            dragView.setBackgroundColor(dragView.getResources().getColor(R.color.dividerColor));
        }
    }
}
