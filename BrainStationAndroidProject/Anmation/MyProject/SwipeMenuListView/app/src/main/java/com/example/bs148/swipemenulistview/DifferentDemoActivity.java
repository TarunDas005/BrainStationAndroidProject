package com.example.bs148.swipemenulistview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

import static com.example.bs148.swipemenulistview.R.id.listView;

public class DifferentDemoActivity extends AppCompatActivity {
    private ArrayList<ListMenu> listMenus;
    public static int[] prgmImages = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j};
    public static String[] prgmNameList = {"Let Us C", "c++", "JAVA", "Jsp", "Microsoft .Net", "Android", "PHP", "Jquery", "JavaScript", "Python"};
    private SwipeMenuListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_demo);
        listMenus = new ArrayList<ListMenu>();
        mListView = (SwipeMenuListView) findViewById(listView);

        for (int i = 0; i < prgmImages.length; i++) {
            ListMenu listMenu = new ListMenu(prgmImages[i], prgmNameList[i]);
            listMenus.add(listMenu);
        }
        CustomDifferentAdapter adapter = new CustomDifferentAdapter(getApplicationContext(), listMenus);
        mListView.setAdapter(adapter);
        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // Create different menus depending on the view type
                switch (menu.getViewType()) {
                    case 0:
                        createMenu1(menu);
                        break;
                    case 1:
                        createMenu2(menu);
                        break;
                    case 2:
                        createMenu3(menu);
                        break;
                }
            }
            private void createMenu1(SwipeMenu menu) {
                SwipeMenuItem item1 = new SwipeMenuItem(
                        getApplicationContext());
                item1.setBackground(new ColorDrawable(Color.rgb(0xE5, 0x18,
                        0x5E)));
                item1.setWidth(dp2px(90));
                //item1.setIcon(R.drawable.ic_action_favorite);
                item1.setTitle("Hello");
                item1.setTitleSize(18);
                item1.setTitleColor(Color.BLACK);

                menu.addMenuItem(item1);
                SwipeMenuItem item2 = new SwipeMenuItem(
                        getApplicationContext());
                item2.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                item2.setWidth(dp2px(90));
                //item2.setIcon(R.drawable.ic_action_good);
                item2.setTitle("Pokkos");
                item2.setTitleSize(18);
                item2.setTitleColor(Color.BLACK);

                menu.addMenuItem(item2);
            }
            private void createMenu2(SwipeMenu menu) {
                SwipeMenuItem item1 = new SwipeMenuItem(
                        getApplicationContext());
                item1.setBackground(new ColorDrawable(Color.rgb(0xE5, 0xE0,
                        0x3F)));
                item1.setWidth(dp2px(90));
                //item1.setIcon(R.drawable.ic_action_important);
                item1.setTitle("EWU");
                item1.setTitleSize(18);
                item1.setTitleColor(Color.BLACK);

                menu.addMenuItem(item1);
                SwipeMenuItem item2 = new SwipeMenuItem(
                        getApplicationContext());
                item2.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                item2.setWidth(dp2px(90));
                //item2.setIcon(R.drawable.ic_action_discard);
                item2.setTitle("NSU");
                item2.setTitleSize(18);
                item2.setTitleColor(Color.BLACK);

                menu.addMenuItem(item2);
            }

            private void createMenu3(SwipeMenu menu) {
                SwipeMenuItem item1 = new SwipeMenuItem(
                        getApplicationContext());
                item1.setBackground(new ColorDrawable(Color.rgb(0x30, 0xB1,
                        0xF5)));
                item1.setWidth(dp2px(90));
                //item1.setIcon(R.drawable.ic_action_about);
                item1.setTitle("ASD");
                item1.setTitleSize(18);
                item1.setTitleColor(Color.BLACK);

                menu.addMenuItem(item1);
                SwipeMenuItem item2 = new SwipeMenuItem(
                        getApplicationContext());
                item2.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                item2.setWidth(dp2px(90));
                //item2.setIcon(R.drawable.ic_action_share);
                item2.setTitle("PQR");
                item2.setTitleSize(18);
                item2.setTitleColor(Color.BLACK);

                menu.addMenuItem(item2);
            }
        };
        mListView.setMenuCreator(creator);

        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                //listview position
                //swipe position
                int pos=position;
                int index1=index;
                return false;
            }
        });
    }
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

}
