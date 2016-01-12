package com.example.mysample.carouselviewexample;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends FragmentActivity {

    public final static int LOOPS = 1000;
    public static int FIRST_PAGE; // = count * LOOPS / 2;
    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.7f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;
    public MyPagerAdapter adapter;
    public ViewPager pager;
    /*** variables for the View */
    public int coverUrl[];
    public static int count;

    public static MainActivity mainActivityCtx;

    public static int currentPage = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        coverUrl = new int[] { R.drawable.image11, R.drawable.image23,
                R.drawable.image3, R.drawable.image33, R.drawable.image4,
                R.drawable.image44, R.drawable.image5, R.drawable.image66,
                R.drawable.image7, R.drawable.image8 };

        mainActivityCtx = this;
        pager = (ViewPager) findViewById(R.id.myviewpager);
        count = coverUrl.length;
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int pageMargin = 0;
        pageMargin = (int) ((metrics.widthPixels / 4) *2);
        pager.setPageMargin(-pageMargin);

        try {
            adapter = new MyPagerAdapter(this, this.getSupportFragmentManager());
            pager.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            FIRST_PAGE = count * LOOPS / 2;

            pager.setOnPageChangeListener(adapter);
            // Set current item to the middle page so we can fling to both
            // directions left and right
            pager.setCurrentItem(FIRST_PAGE); // FIRST_PAGE
            // pager.setFocusableInTouchMode(true);
            pager.setOffscreenPageLimit(3);
            // Set margin for pages as a negative number, so a part of next and
            // previous pages will be showed

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
