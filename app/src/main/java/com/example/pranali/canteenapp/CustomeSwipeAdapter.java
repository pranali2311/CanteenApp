package com.example.pranali.canteenapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class CustomeSwipeAdapter extends PagerAdapter {

    private int[] image_resources={R.drawable.breakfast, R.drawable.lunch};
   //private int[] recyclerId={R.id.breakfastRecycler,R.id.lunchRecycler};
    private String[] type_resources={"BREAKFAST","LUNCH"};



    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomeSwipeAdapter(Context ctx){
        this.ctx=ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view==(LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.choose,container,false);


        ImageView typeImage=(ImageView)item_view.findViewById(R.id.typeImage);
        TextView typeText=(TextView)item_view.findViewById(R.id.typeText);

        typeImage.setImageResource(image_resources[position]);
        typeText.setText(type_resources[position]);


        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
