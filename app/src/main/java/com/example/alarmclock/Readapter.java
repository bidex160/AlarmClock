package com.example.alarmclock;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Readapter extends RecyclerView.Adapter<Readapter.ViewHolder> {

    ArrayList<Array> arrays = new ArrayList<>();
    Context context;
    private Array inc;

    public Readapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelayout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String h = String.valueOf(arrays.get(position).getHours());
        String m = String.valueOf(arrays.get(position).getMin());
        holder.txt1.setText(h);
        holder.txt2.setText(m);
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                int rh = arrays.get(position).getHours();
                int rm = arrays.get(position).getMin();
                boolean t = false;

                for (Array array:arrays){
                    if (array.getHours()== rh && array.getMin()==rm){

                     Intent intent = new Intent(context, MainActivity.class);
                     intent.putExtra("rh", rh);
                     intent.putExtra("rm", rm);
                     context.startActivity(intent);
                    }
                }


                return false;




            }
        });

    }

    @Override
    public int getItemCount() {
        return arrays.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt1, txt2;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = (TextView)itemView.findViewById(R.id.houredt);
            txt2 = (TextView)itemView.findViewById(R.id.minedt);
            cardView = (CardView)itemView.findViewById(R.id.cardv);
        }
    }

    public void setArrays(ArrayList<Array> arrays) {
        this.arrays = arrays;
        notifyDataSetChanged();
    }
}
