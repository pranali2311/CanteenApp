package com.example.pranali.canteenapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapterBreakfast extends RecyclerView.Adapter<MyAdapterBreakfast.ViewHolder>
{
    private List<ListItemBreakfast> listItems;
    private Context context;
    TextView mTotalPrice;
    int[] mItemCounts;

    public MyAdapterBreakfast(List<ListItemBreakfast> listItems, Context context,TextView tp,int[] itemCounts) {
        this.listItems = listItems;
        this.context = context;
        mTotalPrice=tp;
        mItemCounts=itemCounts;
    }

    @Override
    public MyAdapterBreakfast.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.breakfast_menu,parent,false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final MyAdapterBreakfast.ViewHolder holder,   int position) {

       final  ListItemBreakfast listItem=listItems.get(position);
        // final MainActivity obj = new MainActivity();
        holder.textViewPrice.setText(listItem.getPrice());
        holder.textViewHead.setText(listItem.getHeading());
        //holder.imgView.setImageResource(listItem.getImgid());
        Glide.with(context).load(listItem.getImgid()).into(holder.imgView);
        holder.imgcnt.setText(listItem.getItemcnt());

        holder.inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String incno;

                incno=listItem.getItemcnt();
                Integer count1=Integer.parseInt(incno);
                int count=count1;
                String totalp=mTotalPrice.getText().toString();
                int totalcount=Integer.parseInt(totalp);
                String currprice=listItem.getPrice();
                int totalcurrprice=Integer.parseInt(currprice);
                count1++;
                int diff=count1-count;
                totalcount=totalcount+diff*totalcurrprice;

                incno=Integer.toString(count1);

                totalp=Integer.toString(totalcount);
                mTotalPrice.setText(totalp);
                listItem.setItemcnt(incno);
                holder.imgcnt.setText(listItem.getItemcnt());
                mItemCounts[holder.getAdapterPosition()]=count1;

            }
        });
        holder.dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String decno;
                decno=listItem.getItemcnt();
                Integer count1=Integer.parseInt(decno);
                String totalp=mTotalPrice.getText().toString();
                int totalcount=Integer.parseInt(totalp);
                String currprice=listItem.getPrice();
                int totalcurrprice=Integer.parseInt(currprice);

                int count=count1;
                if(count!=0) {
                    count1--;

                    int diff=count-count1;
                    totalcount=totalcount-diff*totalcurrprice;


                    decno = Integer.toString(count1);
                    totalp=Integer.toString(totalcount);
                    mTotalPrice.setText(totalp);
                    listItem.setItemcnt(decno);
                    holder.imgcnt.setText(listItem.getItemcnt());
                    mItemCounts[holder.getAdapterPosition()]=count1;
                    //  obj.setTextView(count,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewPrice;
        public ImageView imgView;
        public TextView imgcnt;
        public ImageButton inc;
        public ImageButton dec;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead=(TextView)itemView.findViewById(R.id.heading);
            textViewPrice=(TextView)itemView.findViewById(R.id.price);
            imgView=(ImageView)itemView.findViewById(R.id.itemimg);
            imgcnt=(TextView)itemView.findViewById(R.id.itemcnt);
            inc=(ImageButton)itemView.findViewById(R.id.inc);
            dec=(ImageButton)itemView.findViewById(R.id.dec);

        }
    }
}