package com.example.demo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecyclerHolder> {

  Activity fragment;
  List<data> modellist;

    private Object ChatFragment;


    public RecycleAdapter(FragmentActivity activity, List<data> modelList) {
        fragment=activity;
        this.modellist=modelList;

    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(fragment).inflate(R.layout.fullname,parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.RecyclerHolder holder, int position) {

        holder.name.setText(modellist.get(position).name);
        holder.surname.setText(modellist.get(position).surname);
        holder.img.setImageResource(modellist.get(position).img);
    }

    @Override
    public int getItemCount() {
        return modellist.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {

        TextView name,surname;
        ImageView img;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            surname=itemView.findViewById(R.id.surname);
            img=itemView.findViewById(R.id.img);

        }
    }
    }
