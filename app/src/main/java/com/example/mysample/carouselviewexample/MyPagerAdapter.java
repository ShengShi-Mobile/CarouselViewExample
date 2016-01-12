package com.example.mysample.carouselviewexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


/**
 * Created by Mickey on 12/14/2015.
 */
public class MyPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    private MyLinearLayout cur = null;
    private MyLinearLayout next = null;
    private MainActivity context;
    private FragmentManager fm;
    private float scale;
    int pCount = 0;

    public MyPagerAdapter(MainActivity context, FragmentManager fm) {
        super(fm);
        this.fm = fm;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        // make the first pager bigger than others
        try {
            if (position == MainActivity.FIRST_PAGE)
                scale = MainActivity.BIG_SCALE;
            else
                scale = MainActivity.SMALL_SCALE;

            position = position % MainActivity.count;

        } catch (Exception e) {
            // TODO: handle exception
        }
        return MyFragment.newInstance(context, position, scale);
    }

    @Override
    public int getCount() {
        int count = 0;
        try {
            count = MainActivity.count * MainActivity.LOOPS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return  count  ;
    }

    @Override
    public void onPageScrolled( int position, float positionOffset, int positionOffsetPixels){
        try {
            if (positionOffset >= 0f && positionOffset <= 1f) {
                cur = getRootView( position );
                next = getRootView( position +1 );

                cur.setScaleBoth(MainActivity.BIG_SCALE   - MainActivity.DIFF_SCALE * positionOffset);
                next.setScaleBoth(MainActivity.SMALL_SCALE  + MainActivity.DIFF_SCALE * positionOffset);

                pCount++;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private MyLinearLayout getRootView(int position) {
        return (MyLinearLayout) fm.findFragmentByTag(this.getFragmentTag(position)).getView().findViewById(R.id.root);
    }

    private String getFragmentTag(int position) {
        return "android:switcher:" + context.pager.getId() + ":" + position;
    }
}

