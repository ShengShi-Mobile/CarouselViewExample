package com.example.mysample.carouselviewexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Mickey on 12/14/2015.
 */
public class MyFragment extends Fragment {
    public static Fragment newInstance(MainActivity context, int pos, float scale) {
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        b.putFloat("scale", scale);

        return Fragment.instantiate(context, MyFragment.class.getName(), b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(400,400);
        LinearLayout fragmentLL  = (LinearLayout) inflater.inflate(R.layout.mf, container, false);
        int pos   = this.getArguments().getInt("pos");
        TextView tv  = (TextView) fragmentLL.findViewById(R.id.text);

        tv.setText("Image " +  pos );

        ImageView iv = (ImageView) fragmentLL.findViewById(R.id.pagerImg);

        iv.setLayoutParams(layoutParams);
        iv.setImageResource(MainActivity.mainActivityCtx.coverUrl[pos] );
        iv.setPadding(15, 15, 15, 15);

        MyLinearLayout root = (MyLinearLayout) fragmentLL.findViewById(R.id.root);
        float scale   = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return fragmentLL;
    }
}
