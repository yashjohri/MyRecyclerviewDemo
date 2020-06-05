package com.example.myrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class mChildAdapter extends RecyclerView.Adapter<mChildAdapter.mChildViewHolder> {

    private Context context;
    private ArrayList<mCategoryData> subcat_list;

    public mChildAdapter(Context context, ArrayList<mCategoryData> subcat_list) {
        this.context = context;
        this.subcat_list = subcat_list;
    }

    @NonNull
    @Override
    public mChildAdapter.mChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.child_item_row, parent, false);
        return new mChildViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mChildAdapter.mChildViewHolder holder, int position) {
        mCategoryData categoryData=subcat_list.get(position);

        holder.sub_title.setText(categoryData.getT());
        //holder.sub_image.setImageURI(Uri.parse(categoryData.getpF()));
        Picasso.get().load(categoryData.getpF()).into(holder.sub_image);
    }

    @Override
    public int getItemCount() {
        return subcat_list.size();
    }

    public class mChildViewHolder extends RecyclerView.ViewHolder{

        ImageView sub_image;
        TextView sub_title;

        public mChildViewHolder(@NonNull View itemView) {
            super(itemView);

            sub_image=itemView.findViewById(R.id.subcat_image);
            sub_title=itemView.findViewById(R.id.subcat_title);
        }
    }
}
