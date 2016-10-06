package com.example.bs148.swipemenulistview;

import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.bs148.swipemenulistview.R.id.listView;

public class SimpleMenuDemoActivity extends AppCompatActivity {
    private ArrayList<ListMenu> listMenus;
    public static int[] prgmImages = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j};
    public static String[] prgmNameList = {"Let Us C", "c++", "JAVA", "Jsp", "Microsoft .Net", "Android", "PHP", "Jquery", "JavaScript", "Python"};
    private SwipeMenuListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_menu_demo);
        listMenus = new ArrayList<ListMenu>();
        mListView = (SwipeMenuListView) findViewById(listView);

        for (int i = 0; i < prgmImages.length; i++) {
            ListMenu listMenu = new ListMenu(prgmImages[i], prgmNameList[i]);
            listMenus.add(listMenu);
        }
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), listMenus);
        mListView.setAdapter(adapter);
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Open");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        mListView.setMenuCreator(creator);

        // swipe button click listner
        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // open
                        Toast.makeText(getApplicationContext(),"Open Button Click",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        // delete
                        Toast.makeText(getApplicationContext(),"Delete Button Click",Toast.LENGTH_SHORT).show();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

        //listview item click listner
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Item Click",Toast.LENGTH_SHORT).show();
            }
        });

        //swipe direction
        // Right
        //mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);

        // Left
        mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
