package com.etateck.expandablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/****************************************************
 *** Created by Fady Fouad on 01-May-20 at 03:30.***
 ***************************************************/
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private Context context;
    private List<String>stringList;

    public RecyclerAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        holder.headerItem.setText(stringList.get(position));

        List<String>strings = new ArrayList<>();
        strings.add("child 0");
        strings.add("child 1");
        strings.add("child 2");
        strings.add("child 3");
        strings.add("child 4");
        strings.add("child 5");
        holder.recyclerView.setAdapter(new ChildAdapter(context,strings));
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setHasFixedSize(true);
        holder.headerItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.recyclerView.setVisibility(holder.recyclerView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView headerItem;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.child_recycler);
            headerItem = itemView.findViewById(R.id.header_tv);
        }
    }
}
