package com.example.and3hw1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and3hw1.Model.Books;
import com.example.and3hw1.OnItemClick;
import com.example.and3hw1.R;
import com.example.and3hw1.databinding.ItemTaskBinding;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    ArrayList<Books>list = new ArrayList<>();
    ItemTaskBinding binding;
    OnItemClick onItemClick;

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding.getRoot());
    }

    public void setOnItemClickListener(OnItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setBook(ArrayList<Books> books){
        list = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void onBind(Books books){
            binding.txtV.setText(books.getTitle());
            binding.imageView.setImageResource(books.getImage());
            itemView.setOnClickListener(v -> {
                onItemClick.onItemClick(getAdapterPosition());
            });
        }
    }
}
