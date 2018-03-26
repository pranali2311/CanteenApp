package com.example.pranali.canteenapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;


public class MyAdapterLunch extends RecyclerView.Adapter<MyAdapterLunch.ViewHolder>
{
    private List<ListItemLunch> listItems;
    private Context context;
    String mDay;

    public MyAdapterLunch(List<ListItemLunch> listItems, Context context,String day) {
        this.listItems = listItems;
        this.context = context;
        this.mDay=day;
    }



    @Override
    public MyAdapterLunch.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.lunch_menu,parent,false);

        return new ViewHolder(v);



    }

    @Override
    public void onBindViewHolder(final MyAdapterLunch.ViewHolder holder, final int position) {

        final ListItemLunch listItem=listItems.get(position);
        holder.menuName.setText(listItem.getMenuname());
        holder.imgView.setImageResource(listItem.getImgid());

        holder.cardbreak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context=view.getContext();
                if(position==0)
                {
                    Intent intent1=new Intent(context,VegetableMenu.class);
                    intent1.putExtra("day",mDay);
                    context.startActivity(intent1);

                }
                if (position==1)
                {
                    Intent intent2=new Intent(context,RiceMenu.class);
                    intent2.putExtra("day",mDay);
                    context.startActivity(intent2);
                }
                if (position==2)
                {
                    Intent intent3=new Intent(context,DesertMenu.class);
                    intent3.putExtra("day",mDay);
                    context.startActivity(intent3);
                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView menuName;
        public ImageView imgView;
        public CardView cardbreak;

        public ViewHolder(View itemView) {
            super(itemView);


            menuName=(TextView)itemView.findViewById(R.id.menuname);
            imgView=(ImageView)itemView.findViewById(R.id.itemimglunch);
            cardbreak=(CardView)itemView.findViewById(R.id.cardbreakfast);

        }
    }

}