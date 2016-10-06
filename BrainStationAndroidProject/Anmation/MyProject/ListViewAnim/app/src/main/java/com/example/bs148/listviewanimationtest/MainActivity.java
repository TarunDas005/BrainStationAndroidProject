package com.example.bs148.listviewanimationtest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nhaarman.listviewanimations.ArrayAdapter;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.ScaleInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingLeftInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingRightInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.OnItemMovedListener;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.TouchViewDraggableManager;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SimpleSwipeUndoAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ListMenu> listMenus;
    //ListView listView;
    DynamicListView listView;
    public static int [] prgmImages={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript","Python"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listView= (ListView) findViewById(R.id.listview);
        listView= (DynamicListView) findViewById(R.id.listview);
        listMenus=new ArrayList<ListMenu>();

        for(int i=0;i<prgmImages.length;i++){
            ListMenu listMenu=new ListMenu(prgmImages[i],prgmNameList[i]);
            listMenus.add(listMenu);
        }

        final CustomAdapter adapter=new CustomAdapter(this,listMenus);

        //Different Test of Adapter

        //AlphaAnimationAdapter
        /*AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);*/

        //ScaleInAnimationAdapter
        /*ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);*/

        //SwingBottomInAnimationAdapter
        /*SwingBottomInAnimationAdapter animationAdapter = new SwingBottomInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);*/

        //SwingLeftInAnimationAdapter
        /*SwingLeftInAnimationAdapter animationAdapter = new SwingLeftInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);*/

        //SwingRightInAnimationAdapter
        /*SwingRightInAnimationAdapter animationAdapter = new SwingRightInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);*/

        //End Adaptrer Test
        //Swipe to delete
        /*SwingRightInAnimationAdapter animationAdapter = new SwingRightInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);
        listView.enableSwipeToDismiss(
                new OnDismissCallback() {
                    @Override
                    public void onDismiss(@NonNull final ViewGroup listView, @NonNull final int[] reverseSortedPositions) {
                        for (int position : reverseSortedPositions) {
                            adapter.remove(position);
                        }
                    }
                }
        );*/

        SimpleSwipeUndoAdapter swipeUndoAdapter = new SimpleSwipeUndoAdapter(adapter, MainActivity.this,
                new OnDismissCallback() {
                    @Override
                    public void onDismiss(@NonNull final ViewGroup listView, @NonNull final int[] reverseSortedPositions) {
                        for (int position : reverseSortedPositions) {
                            adapter.remove(position);
                        }
                    }
                }
        );
        swipeUndoAdapter.setAbsListView(listView);
        listView.setAdapter(swipeUndoAdapter);
        listView.enableSimpleSwipeUndo();





    }

    public void addClick(View view){
        ListMenu listMenu=new ListMenu(R.drawable.a,"Hello");
        //insert
        listView.insert(0, listMenu);
    }

}
