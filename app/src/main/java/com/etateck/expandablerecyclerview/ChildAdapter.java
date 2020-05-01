package com.etateck.expandablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/****************************************************
 *** Created by Fady Fouad on 01-May-20 at 03:35.***
 ***************************************************/
public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {
    Context context;
    List<String>stringList;

    public ChildAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.child_item, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        holder.textView.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.child_text);
        }
    }
}
