package com.example.myrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mParentAdapter extends RecyclerView.Adapter<mParentAdapter.mParentViewHolder> {

    private Context context;
    private ArrayList<mCategory> cat_list;

    public mParentAdapter(Context context, ArrayList<mCategory> cat_list) {
        this.context = context;
        this.cat_list = cat_list;
    }

    @NonNull
    @Override
    public mParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.parent_item_row, parent, false);
        return new mParentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mParentViewHolder holder, int position) {
        mCategory category=cat_list.get(position);

        holder.cat_title.setText(category.getTitle());

        mChildAdapter childAdapter=new mChildAdapter(context, category.getData());
        holder.rv_child.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rv_child.setAdapter(childAdapter);
    }

    @Override
    public int getItemCount() {
        return cat_list.size();
    }

    public class mParentViewHolder extends RecyclerView.ViewHolder{

        TextView cat_title;
        RecyclerView rv_child;

        public mParentViewHolder(@NonNull View itemView) {
            super(itemView);

            cat_title=itemView.findViewById(R.id.cat_title);
            rv_child=itemView.findViewById(R.id.rv_child);
        }
    }
}
