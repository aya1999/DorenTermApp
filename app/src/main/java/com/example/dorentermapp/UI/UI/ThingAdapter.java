package com.example.dorentermapp.UI.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dorentermapp.R;
import com.example.dorentermapp.UI.Entity.Terms;

import java.util.List;

public class ThingAdapter extends RecyclerView.Adapter<ThingAdapter.TermViewHolder> {

    class TermViewHolder extends  RecyclerView.ViewHolder
    {
        private final TextView thingItemView;
        private final TextView thingItemView2;
        private TermViewHolder(View itemView){
            super(itemView);
            thingItemView=itemView.findViewById(R.id.textView);
            thingItemView2=itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                final Terms current = mThings.get(position);
                Intent intent = new Intent(context, TermAddPage.class);//where you want it to go i guess
                intent.putExtra("id", current.getTermID());
                intent.putExtra("name", current.getTermTitle());
                intent.putExtra("start", current.getTermStartDate());
                intent.putExtra("end", current.getTermEndDate());
                context.startActivity(intent);
            });
        }
    }
    private List<Terms> mThings;
    private final Context context;
    private final LayoutInflater mInflater;

    public ThingAdapter(Context context){
        mInflater=LayoutInflater.from(context);
        this.context = context;
    }
    @NonNull
    @Override
    public TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_item,parent,false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermViewHolder holder, int position) {
        if(mThings!=null){
            Terms current = mThings.get(position);
            holder.thingItemView.setText(current.getTermTitle());
            holder.thingItemView2.setText(current.getTermStartDate());
        }
        else{
            holder.thingItemView.setText("No Term Name");
            holder.thingItemView2.setText("No Term Start Date");

        }
    }

    public void setThings(List<Terms> things){
        mThings = things;
        notifyDataSetChanged();//refresh
    }
    @Override
    public int getItemCount() {
        if (mThings != null) {
            return mThings.size();
        }
        else
            return 0;
    }
}
